package order.service.driver.http.order.create

import order.service.application.commands.CreateOrder
import order.service.application.domain.models.customer.CustomerId
import order.service.application.domain.models.customer.StreetAddress
import order.service.application.domain.models.partner.PartnerId
import order.service.driver.http.order.shared.json.OrderAddressJson
import order.service.driver.http.order.shared.json.OrderItemJson
import order.service.driver.http.order.shared.json.PaymentJson
import java.util.UUID

data class Request(
    val customerId: UUID,
    val partnerId: UUID,
    val items: List<OrderItemJson>,
    val deliveryAddress: OrderAddressJson,
    val payment: PaymentJson,
) {
    fun toCommand() =
        CreateOrder(
            partnerId = PartnerId(partnerId),
            customerId = CustomerId(customerId),
            deliveryAddress =
                StreetAddress(
                    id = UUID.randomUUID(),
                    street = deliveryAddress.street,
                    city = deliveryAddress.city,
                    postalCode = deliveryAddress.postalCode,
                ),
            items = items.map { item -> item.toModel() },
            payment = payment.toCommand(),
        )
}
