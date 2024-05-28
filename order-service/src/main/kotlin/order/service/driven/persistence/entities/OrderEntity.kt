package order.service.driven.persistence.entities

import order.service.application.domain.events.OrderCreated
import order.service.application.domain.models.order.OrderStatus
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.UUID

@Table( "orders")
data class OrderEntity(
    val orderId: UUID,
    val customerId: UUID,
    val partnerId: UUID,
    val status: String,
    val trackingId: UUID,
) {
    companion object {
        fun fromEvent(event: OrderCreated) =
            OrderEntity(
                orderId = event.orderId.id,
                customerId = event.customerId.value,
                partnerId = event.partnerId.value,
                status = OrderStatus.PENDING.toString(),
                trackingId = UUID.randomUUID(),
            )
    }
}
