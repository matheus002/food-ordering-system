package order.service.application.domain.models

import order.service.application.domain.events.OrderCreated as OrderCreatedEvent

sealed interface Order : AggregateRoot {
    override val version: Version

    companion object {
        fun createOrder() = OrderCreatedEvent()
    }
}
