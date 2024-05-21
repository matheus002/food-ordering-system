package order.service.driver.http.order.shared.json

import order.service.application.domain.models.order.Money
import order.service.application.domain.models.payment.Currency
import order.service.application.domain.models.payment.Installments
import order.service.application.domain.models.payment.Method
import order.service.application.domain.models.payment.Payment
import order.service.application.domain.models.payment.PaymentId
import java.math.BigDecimal
import java.util.UUID

data class PaymentJson(
    val id: UUID,
    val amount: BigDecimal,
    val currency: String,
    val method: String,
    val installments: InstallmentsJson,
) {
    fun toCommand() =
        Payment(
            id = PaymentId(id),
            amount = Money(amount),
            currency = Currency.valueOf(currency),
            installments = Installments(quantity = installments.quantity, price = Money(amount)),
            method = Method.valueOf(method),
        )
}
