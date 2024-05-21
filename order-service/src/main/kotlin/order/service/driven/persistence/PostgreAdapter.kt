package order.service.driven.persistence

import order.service.application.ports.output.OrderRepository
import org.springframework.core.annotation.Order

class PostgreAdapter : OrderRepository {
    override fun save(order: Order): Order {
        // save to database
        TODO("Not yet implemented")
    }

    override fun findByTrackingId(trackingId: String): Order? {
        TODO("Not yet implemented")
    }
}
