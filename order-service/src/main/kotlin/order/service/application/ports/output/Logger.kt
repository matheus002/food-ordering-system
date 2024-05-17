package order.service.application.ports.output

interface Logger {
    fun info(
        identifier: String,
        message: String?,
    )
}
