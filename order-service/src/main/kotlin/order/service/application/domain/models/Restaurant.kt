package order.service.application.domain.models

import order.service.application.domain.models.restaurant.RestaurantId

data class Restaurant(
    val restaurantId: RestaurantId,
): AggregateRoot {
}