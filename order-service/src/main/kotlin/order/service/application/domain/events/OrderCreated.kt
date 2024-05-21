package order.service.application.domain.events

import order.service.application.domain.models.customer.CustomerId
import order.service.application.domain.models.customer.StreetAddress
import order.service.application.domain.models.order.OrderId
import order.service.application.domain.models.partner.PartnerId
import order.service.application.domain.models.payment.Payment
import java.time.ZonedDateTime

data class OrderCreated(
    val customerId: CustomerId,
    val partnerId: PartnerId,
    val payment: Payment,
    val deliveryAddress: StreetAddress,
    override val orderId: OrderId,
    override val createdAt: ZonedDateTime,
) : CreateEvent
