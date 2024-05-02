package order.service.application.domain.models.order

data class OrderItem(
    val id: Long,
    val orderId : OrderId,
    val product: Product,
    val quantity: Int,
    val price: Money,
    val subTotalPrice: Money,
) {

    init {
        require(subTotalPrice === price.multiply(quantity)) { "SubTotal is wrong" }
    }
}