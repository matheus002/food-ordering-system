package order.service.application.domain.models.order

import java.util.UUID

data class Product(
    val id: UUID,
    var name: String,
    var price: Money,
) {
    fun updateWithConfirmedNameAndPrice(
        name: String,
        price: Money,
    ) {
        this.name = name
        this.price = price
    }
}
