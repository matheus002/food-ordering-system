package order.service.application.commands

import order.service.application.domain.models.customer.CustomerId
import order.service.application.domain.models.customer.StreetAddress
import order.service.application.domain.models.order.OrderItem
import order.service.application.domain.models.restaurant.RestaurantId

data class CreateOrder(
    val restaurantId: RestaurantId,
    val customerId: CustomerId,
    val deliveryAddress: StreetAddress,
    val items: List<OrderItem>,
) : Command
