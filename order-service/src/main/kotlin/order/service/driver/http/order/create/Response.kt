package order.service.driver.http.order.create

import java.util.UUID

data class Response(
    val orderTrackingId: UUID,
    val orderStatus: String,
    val message: String,
)
