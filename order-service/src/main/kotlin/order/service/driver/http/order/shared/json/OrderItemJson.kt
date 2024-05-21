package order.service.driver.http.order.shared.json

import order.service.application.domain.models.order.Money
import order.service.application.domain.models.order.OrderItem
import order.service.application.domain.models.order.OrderItemId
import java.math.BigDecimal

data class OrderItemJson(
    val orderItemId: Long,
    val quantity: Int,
    val price: BigDecimal,
    val product: ProductJson,
    val subTotal: BigDecimal,
) {
    fun toModel() =
        OrderItem(
            orderId = null,
            orderItemId = OrderItemId(orderItemId),
            quantity = quantity,
            price = Money(price),
            subTotalPrice = Money(subTotal),
            product = product.toModel(),
        )
}
