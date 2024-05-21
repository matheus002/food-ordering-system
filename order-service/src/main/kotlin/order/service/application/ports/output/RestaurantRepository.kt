package order.service.application.ports.output

interface RestaurantRepository {
    fun findRestaurantInformation(restaurant: Restaurant): Restaurant?
}
