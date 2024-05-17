package order.service.application.ports.output

import org.springframework.core.annotation.Order

interface OrderRepository {
    fun save(order: Order): Order

    fun findByTrackingId(trackingId: String): Order?
}
