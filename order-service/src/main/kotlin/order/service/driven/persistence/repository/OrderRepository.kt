package order.service.driven.persistence.repository

import order.service.driven.persistence.entities.OrderEntity
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface OrderRepository : CoroutineCrudRepository<OrderEntity, Int>
