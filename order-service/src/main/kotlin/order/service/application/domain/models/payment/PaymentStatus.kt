package order.service.application.domain.models.payment

enum class PaymentStatus {
    CREATED,
    PAID,
    COMPLETED,
    CANCELLED,
    FAILED,
}
