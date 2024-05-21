package order.service.application.domain.events

import order.service.application.domain.models.order.OrderId
import java.time.ZonedDateTime

sealed interface OrderEvent {
    val orderId: OrderId
    val createdAt: ZonedDateTime
}

sealed interface CreateEvent : OrderEvent

sealed interface AuthorizeEvent : OrderEvent

sealed interface CancelEvent : OrderEvent
