package order.service.driver.http.order.shared.json

import order.service.application.domain.models.order.Money
import order.service.application.domain.models.order.Product
import java.math.BigDecimal
import java.util.UUID

data class ProductJson(
    val name: String,
    val price: BigDecimal,
) {
    fun toModel() =
        Product(
            id = UUID.randomUUID(),
            name = name,
            price = Money(price),
        )
}
