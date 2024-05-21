package order.service.application.commands

import order.service.application.domain.models.customer.CustomerId
import order.service.application.domain.models.customer.StreetAddress
import order.service.application.domain.models.order.OrderItem
import order.service.application.domain.models.partner.PartnerId
import order.service.application.domain.models.payment.Payment

data class CreateOrder(
    val partnerId: PartnerId,
    val customerId: CustomerId,
    val deliveryAddress: StreetAddress,
    val items: List<OrderItem>,
    val payment: Payment,
) : Command
