package order.service.application.ports.out

interface Logger {
    fun info(
        identifier: String,
        message: String?,
    )
}
