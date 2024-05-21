package order.service.application.domain.models.payment

import order.service.application.domain.models.order.Money

data class Installments(
    val quantity: Int,
    val price: Money,
)
