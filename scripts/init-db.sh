#!/bin/bash
set -e

# Default values for database credentials
: ${POSTGRES_USER:=admin}
: ${POSTGRES_PASSWORD:=docker}
: ${POSTGRES_DB:=order_ms_adm}

export PGPASSWORD="$POSTGRES_PASSWORD"

# Wait for PostgreSQL to be ready
until psql -U "$POSTGRES_USER" -h "localhost" -d "$POSTGRES_DB" -c '\q'; do
  >&2 echo "Postgres is unavailable - sleeping"
  sleep 1
done

>&2 echo "Postgres is up - executing command"

# List of databases to be created
databases=("restaurant_ms_adm" "payment_ms_adm")

# Function to check if a database exists
function database_exists() {
  local dbname=$1
  if psql -U "$POSTGRES_USER" -h "localhost" -d "$POSTGRES_DB" -tc "SELECT 1 FROM pg_database WHERE datname = '$dbname';" | grep -q 1; then
    return 0
  else
    return 1
  fi
}

# Create databases if they do not exist
for db in "${databases[@]}"; do
  if ! database_exists "$db"; then
    echo "Creating database '$db'..."
    psql -U "$POSTGRES_USER" -h "localhost" -d "$POSTGRES_DB" -c "CREATE DATABASE \"$db\";"
  else
    echo "Database '$db' already exists. Skipping."
  fi
done

echo "Database initialization complete."
