package order.service.application.domain.models

sealed interface AggregateRoot {
    val version: Version
}
