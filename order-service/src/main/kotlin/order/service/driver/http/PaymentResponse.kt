package order.service.driver.http

import java.math.BigDecimal

data class PaymentResponse(
    val id: String,
    val sagaId: String,
    val orderId: String,
    val paymentId: String,
    val customerId: String,
    val price: BigDecimal,
    val paymentStatus: String,
    val failureMessages: List<String>,
)
