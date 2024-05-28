package order.service.application.domain.models.order

import java.util.UUID

data class OrderId(val id: UUID) {
    companion object {
        fun create(): OrderId = OrderId(UUID.randomUUID())
    }
}
