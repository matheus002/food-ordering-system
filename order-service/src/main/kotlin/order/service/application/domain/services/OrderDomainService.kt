package order.service.application.domain.services

import order.service.application.domain.events.CancelEvent
import order.service.application.domain.events.OrderCreated
import order.service.application.domain.events.OrderPaid
import order.service.application.domain.models.OrderOrquestration

interface OrderDomainService {
    fun validateAndInitiateOrder(
        order: OrderOrquestration,
        restaurant: Restaurant,
    ): OrderCreated

    fun payOrder(order: OrderOrquestration): OrderPaid

    fun approveOrder(order: OrderOrquestration)

    fun cancelOrderPayment(
        order: OrderOrquestration,
        failureMessages: List<String>,
    ): CancelEvent

    fun cancelOrder(
        order: OrderOrquestration,
        failureMessages: List<String>,
    )
}
