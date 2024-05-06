package order.service.application.domain.models.order

data class OrderItem(
    var orderItemId: OrderItemId,
    var orderId: OrderId,
    val product: Product,
    val quantity: Int,
    val price: Money,
    val subTotalPrice: Money,
) {
    init {
        require(subTotalPrice === price.multiply(quantity)) { "SubTotal is wrong" }
    }

    fun initializeOrderItems(
        orderId: OrderId,
        orderItemId: OrderItemId,
    ) {
        this.orderId = orderId
        this.orderItemId = orderItemId
    }
}
