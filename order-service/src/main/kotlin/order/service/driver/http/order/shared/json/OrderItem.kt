package order.service.driver.http.order.shared.json

import java.math.BigDecimal
import java.util.UUID

data class OrderItem(
    val productId: UUID,
    val quantity: Int,
    val price: BigDecimal,
    val subTotal: BigDecimal,
)