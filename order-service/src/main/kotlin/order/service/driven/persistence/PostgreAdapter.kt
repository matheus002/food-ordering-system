package order.service.driven.persistence

import order.service.application.domain.events.OrderCreated
import order.service.application.ports.output.OrderRepository
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
class PostgreAdapter : OrderRepository {

    override suspend fun save(event: OrderCreated) {
        TODO("Not yet implemented")
    }

    override fun findByTrackingId(trackingId: String): Order? {
        TODO("Not yet implemented")
    }
}
