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
        require(subTotalPrice.amount.compareTo(price.multiply(quantity).amount) == 0) {
            "SubTotal is wrong subtotal: ${subTotalPrice.amount} totalPrice: ${ price.multiply(quantity).amount}"
        }
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
