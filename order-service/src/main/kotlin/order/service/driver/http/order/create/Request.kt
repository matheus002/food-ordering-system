package order.service.driver.http.order.create

import order.service.application.commands.CreateOrder
import order.service.application.domain.models.restaurant.RestaurantId
import order.service.driver.http.order.shared.json.OrderAddress
import order.service.driver.http.order.shared.json.OrderItem
import java.math.BigDecimal
import java.util.UUID

data class Request(
    val customerId: UUID,
    val restaurantId: UUID,
    val price: BigDecimal,
    val items: List<OrderItem>,
    val address: OrderAddress,
) {
    fun toCommand() =
        CreateOrder(
            restaurantId = RestaurantId(restaurantId),
        )
}
