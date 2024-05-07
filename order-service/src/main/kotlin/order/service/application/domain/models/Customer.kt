package order.service.application.domain.models

import order.service.application.domain.models.customer.CustomerId

data class Customer(
    val customerId: CustomerId,
): AggregateRoot {
}