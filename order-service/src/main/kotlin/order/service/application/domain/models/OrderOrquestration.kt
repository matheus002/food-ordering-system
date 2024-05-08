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
    var failureMessages: MutableList<String?>,
) : AggregateRoot {
    fun initializeOrder() {
        orderId = OrderId(UUID.randomUUID())
        trackingId = TrackingId(UUID.randomUUID())
        status = OrderStatus.PENDING
        initializeOrderItems()
    }

    fun validateOrder() {
        validateInitialOrder()
        validateTotalPrice()
        validateItemsPrice()
    }

    fun pay() {
        if (status != OrderStatus.PENDING) {
            throw OrderDomainException("Order is not in correct state for pay operation")
        }
        status = OrderStatus.PAID
    }

    fun approve() {
        if (status != OrderStatus.PAID) {
            throw OrderDomainException("Order is not in correct state for approve operation")
        }
        status = OrderStatus.APPROVED
    }

    fun initCancel(failureMessages: List<String?>) {
        if (status != OrderStatus.PAID) {
            throw OrderDomainException("Order is not in correct state for initCancel operation")
        }
        status = OrderStatus.CANCELLING
        updateFailureMessages(failureMessages)
    }

    fun cancel(failureMessages: List<String?>) {
        if (!(status == OrderStatus.CANCELLING || status == OrderStatus.PENDING)) {
            throw OrderDomainException("Order is not in correct state for cancel operation")
        }
        status = OrderStatus.CANCELLED
        updateFailureMessages(failureMessages)
    }

    private fun updateFailureMessages(failures: List<String?>) {
        if (failureMessages.isNotEmpty() && failures.isNotEmpty()) {
            failureMessages.addAll(failures)
        }
        if (failureMessages.isEmpty()) {
            failureMessages = failures.toMutableList()
        }
    }

    private fun validateInitialOrder() {
        if (status != null || orderId != null) {
            throw OrderDomainException("Order is not in correct state for initialization ")
        }
    }

    private fun validateTotalPrice() {
        if (price == null || price.isGreaterThanZero()) {
            throw OrderDomainException("Total price must be greater than zero.")
        }
    }

    private fun validateItemsPrice() {
        val orderItemsTotal =
            items.stream().map { orderItem ->
                validateItemPrice(orderItem)
                orderItem.subTotalPrice
            }
                .reduce(Money.ZERO, Money::add)
        if (price?.equals(orderItemsTotal) != true) {
            throw OrderDomainException("Total price ${price?.amount} is not equals to Order items total: ${orderItemsTotal?.amount} ")
        }
    }

    private fun validateItemPrice(item: Item) {
        if (!item.isPriceValid()) {
            throw OrderDomainException("Order Item price: ${item.price.amount} is not valid for product: ${item.product.id}")
        }
    }

    private fun initializeOrderItems() {
        var itemId: Long = 1
        items.forEach {
            it.initializeOrderItems(it.orderId, OrderItemId(itemId++))
        }
    }
}
