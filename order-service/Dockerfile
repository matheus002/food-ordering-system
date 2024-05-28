FROM gradle:8.7-jdk21 AS Builder

WORKDIR /app

COPY build.gradle.kts settings.gradle.kts ./
COPY gradle ./gradle
COPY src ./src
RUN gradle build --no-daemon

FROM alpine:latest

# Install dependencies
RUN apk update && apk add --no-cache openjdk21-jre

# Prints installed java version, just for checking
RUN java --version

WORKDIR /app
# Set the JAVA_HOME environment variable
ENV JAVA_HOME=/usr/lib/jvm/java-21-openjdk
ENV PATH="$JAVA_HOME/bin:${PATH}"

COPY --from=builder /app/build/libs/*.jar app.jar
EXPOSE 3333
ENTRYPOINT ["java", "-jar", "app.jar"]