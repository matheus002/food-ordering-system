package order.service.driver.http.order.create

import order.service.application.commands.CreateOrder
import order.service.application.ports.input.CommandHandler
import order.service.application.ports.output.Logger
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/create")
class OrderCreateEndpoint(
    private val handler: CommandHandler<CreateOrder>,
    private val logger: Logger,
) {
    @PostMapping
    suspend fun create(
        @RequestBody request: Request,
    ): ResponseEntity<String> {
        logger.info("request-handler", "Request received for endpoint /create: $request")

        val command = request.toCommand()

        logger.info(
            "request-handler",
            "Creating order for customer:" +
                "${command.customerId} at partner: ${request.partnerId}",
        )

        handler.handle(command)
        return ResponseEntity.noContent().build()
    }
}
