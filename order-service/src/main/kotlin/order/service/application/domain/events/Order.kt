package order.service.application.domain.events

import order.service.application.domain.models.OrderOrquestration
import java.time.ZonedDateTime

sealed interface OrderEvent {
    val order: OrderOrquestration
    val createdAt: ZonedDateTime
}

sealed interface CreateEvent : OrderEvent

sealed interface AuthorizeEvent : OrderEvent

sealed interface CancelEvent : OrderEvent
