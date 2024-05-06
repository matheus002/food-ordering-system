package order.service.application.domain.models

import order.service.application.domain.exceptions.OrderDomainException
import order.service.application.domain.models.customer.CustomerId
import order.service.application.domain.models.customer.StreetAddress
import order.service.application.domain.models.order.Money
import order.service.application.domain.models.order.OrderId
import order.service.application.domain.models.order.OrderItemId
import order.service.application.domain.models.order.OrderStatus
import order.service.application.domain.models.order.TrackingId
import order.service.application.domain.models.restaurant.RestaurantId
import java.util.UUID
import order.service.application.domain.models.order.OrderItem as Item

data class OrderOrquestration(
    var orderId: OrderId?,
    val customerId: CustomerId,
    val restaurantId: RestaurantId,
    val deliveryAddress: StreetAddress,
    val price: Money?,
    val items: List<Item>,
    var trackingId: TrackingId,
    var status: OrderStatus?,
    var failureMessages: List<String?>,
) : AggregateRoot {
    fun initializeOrder() {
        orderId = OrderId(UUID.randomUUID())
        trackingId = TrackingId(UUID.randomUUID())
        status = OrderStatus.PENDING
        initializeOrderItems()
    }

    fun validateOrder() {
        validateInicialOrder()
        validateTotalPrice()
        validateItemsPrice()
    }

    private fun validateInicialOrder() {
        if (status != null || orderId != null) {
            throw OrderDomainException("Order is not in correct state for initialization ")
        }
    }

    private fun validateTotalPrice() {
        if (price == null || price.isGreaterThanZero()) {
            throw OrderDomainException("Total price must be greater than zero.")
        }
    }

    private fun validateItemsPrice(): Money {
        return items.stream().map { orderItem ->
            validateItemPrice(orderItem)
            orderItem.subTotalPrice
        }
            .reduce(Money.ZERO, Money::add)
    }

    private fun validateItemPrice(item: Item) {
    }

    private fun initializeOrderItems() {
        var itemId: Long = 1
        items.forEach {
            it.initializeOrderItems(it.orderId, OrderItemId(itemId++))
        }
    }
}
