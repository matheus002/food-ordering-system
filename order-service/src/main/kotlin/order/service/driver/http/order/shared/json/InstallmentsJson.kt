package order.service.driver.http.order.shared.json

import java.math.BigDecimal

data class InstallmentsJson(
    val quantity: Int,
    val price: BigDecimal,
)
