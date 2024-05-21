package order.service.application.domain.models

import order.service.application.commands.CreateOrder
import order.service.application.domain.models.order.OrderId
import java.time.ZoneId
import java.time.ZonedDateTime
import order.service.application.domain.events.OrderCreated as OrderCreatedEvent

sealed interface Order : AggregateRoot {
    override val version: Version

    companion object {
        fun create(createOrderCommand: CreateOrder) =
            OrderCreatedEvent(
                customerId = createOrderCommand.customerId,
                partnerId = createOrderCommand.partnerId,
                payment = createOrderCommand.payment,
                deliveryAddress = createOrderCommand.deliveryAddress,
                orderId = OrderId.create(),
                createdAt = ZonedDateTime.now(ZoneId.of("UTC")),
            )
    }
}
