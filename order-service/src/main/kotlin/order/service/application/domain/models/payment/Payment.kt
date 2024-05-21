package order.service.application.domain.models.payment

import order.service.application.domain.models.order.Money

data class Payment(
    val id: PaymentId,
    val amount: Money,
    val currency: Currency,
    val installments: Installments,
    val method: Method,
)
