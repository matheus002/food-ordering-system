package order.service.application.domain.events

import order.service.application.domain.models.Version
import order.service.application.domain.models.order.OrderId
import order.service.application.domain.models.order.OrderItem
import java.time.Instant

class OrderCreatedEvent(
    override val version: Version,
    val createdAt: Instant,
    val orderId: OrderId,
    val items: List<OrderItem>,
) : Event
