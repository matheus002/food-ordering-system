package order.service.application.domain.models.order

enum class OrderStatus {
    PENDING,
    PAID,
    APPROVED,
    CANCELLING,
    CANCELLED,
}
