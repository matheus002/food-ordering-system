package order.service.application.domain.models.order

data class OrderItem(
    var orderId: OrderId?,
    var orderItemId: OrderItemId?,
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

    fun isPriceValid(): Boolean {
        return price.isGreaterThanZero() &&
            price == product.price &&
            price.multiply(quantity) == subTotalPrice
    }
}
