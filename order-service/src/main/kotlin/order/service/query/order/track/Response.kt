package order.service.query.order.track

import java.util.UUID

data class Response(
    val orderTracingID: UUID,
    val orderStatus: String,
    val failureMessage: List<String>,
)
