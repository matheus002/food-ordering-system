package order.service.application.domain.models.order

import java.util.UUID

data class Product(
    val id: UUID,
    val name: String,
    val price: Money
)