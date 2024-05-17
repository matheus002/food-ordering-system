package order.service.driven

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.slf4j.MDC
import order.service.application.ports.output.Logger as LoggerInterface

class LoggerAdapter(
    private val logger: Logger = LoggerFactory.getLogger(Logger::class.java),
) : LoggerInterface {
    override fun info(
        identifier: String,
        message: String?,
    ) {
        MDC.put("identifier", identifier)
        logger.info(message)
    }
}
