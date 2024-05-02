package order.service.application.domain.models

import order.service.application.domain.models.customer.CustomerId
import order.service.application.domain.models.customer.StreetAddress
import order.service.application.domain.models.order.Money
import order.service.application.domain.models.order.OrderStatus
import order.service.application.domain.models.order.TrackingId
import order.service.application.domain.models.restaurant.RestaurantId
import order.service.application.domain.models.order.OrderItem as Item

data class OrderRequested(
    val customerId: CustomerId,
    val restaurantId: RestaurantId,
    val deliveryAddress: StreetAddress,
    val price: Money,
    val items: List<Item>,
    val trackingId: TrackingId,
    val status: OrderStatus,
): AggregateRoot