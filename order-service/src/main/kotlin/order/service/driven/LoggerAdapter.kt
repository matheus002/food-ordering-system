package order.service.driven

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.slf4j.MDC
import order.service.application.ports.out.Logger as LoggerInterface
import org.springframework.context.annotation.Bean

class LoggerAdapter(
    private val logger: Logger = LoggerFactory.getLogger(Logger::class.java)
): LoggerInterface {

    override fun info(identifier: String, message: String?) {
       MDC.put("identifier", identifier)
        logger.info(message)
    }
}