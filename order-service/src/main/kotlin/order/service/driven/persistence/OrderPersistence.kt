package order.service.driven.persistence

import order.service.application.domain.events.OrderCreated
import order.service.application.ports.output.OrderRepository
import order.service.driven.persistence.entities.OrderEntity
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Service
import order.service.driven.persistence.repository.OrderRepository as OrderPersistenceRepository

@Service
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
class OrderPersistence(
    private val repository: OrderPersistenceRepository,
) : OrderRepository {
    override suspend fun save(event: OrderCreated) {
        val entity = OrderEntity.fromEvent(event)
        println("saving order $entity")
        repository.save(entity)
    }

    override suspend fun findByTrackingId(trackingId: String): Order? {
        TODO("Not yet implemented")
    }
}
