package order.service.application.ports.input.message.listener.payment

import order.service.driver.http.PaymentResponse

interface PaymentResponseListenerMessage {
    fun paymentResponse(payment: PaymentResponse)

    fun paymentCancelled(payment: PaymentResponse)
}
