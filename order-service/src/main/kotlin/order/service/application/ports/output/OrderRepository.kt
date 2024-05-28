package order.service.application.ports.output

import order.service.application.domain.events.OrderCreated
import org.springframework.core.annotation.Order

interface OrderRepository {
    suspend fun save(event: OrderCreated)

    suspend fun findByTrackingId(trackingId: String): Order?
}
