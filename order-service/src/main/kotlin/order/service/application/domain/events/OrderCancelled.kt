package order.service.application.domain.events

import order.service.application.domain.models.OrderOrquestration
import java.time.ZonedDateTime

data class OrderCancelled(
    override val order: OrderOrquestration,
    override val createdAt: ZonedDateTime,
) : CancelEvent
