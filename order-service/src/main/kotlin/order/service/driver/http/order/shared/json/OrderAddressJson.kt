package order.service.driver.http.order.shared.json

data class OrderAddressJson(
    val street: String,
    val postalCode: String,
    val city: String,
)
