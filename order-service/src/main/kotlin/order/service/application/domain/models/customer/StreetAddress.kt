package order.service.application.domain.models.customer

import java.util.UUID

data class StreetAddress(
    val id: UUID,
    val street: String,
    val city: String,
    val postalCode: String,

)