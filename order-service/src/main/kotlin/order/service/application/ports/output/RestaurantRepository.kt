package order.service.application.ports.output

import order.service.application.domain.models.Restaurant

interface RestaurantRepository {
    fun findRestaurantInformation(restaurant: Restaurant): Restaurant?
}
