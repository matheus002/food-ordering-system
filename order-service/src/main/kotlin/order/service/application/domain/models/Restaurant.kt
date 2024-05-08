package order.service.application.domain.models

import order.service.application.domain.models.order.Product
import order.service.application.domain.models.restaurant.RestaurantId

data class Restaurant(
    val restaurantId: RestaurantId,
    val products: List<Product>,
    val active: Boolean,
) : AggregateRoot
