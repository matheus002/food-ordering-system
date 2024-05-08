package order.service.driver.http.order.shared.json

data class OrderAddress(
    val street: String,
    val postalCode: String,
    val city: String,
)
