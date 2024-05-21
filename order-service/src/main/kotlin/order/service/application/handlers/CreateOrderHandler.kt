package order.service.application.handlers

import order.service.application.commands.CreateOrder
import order.service.application.domain.models.Order
import order.service.application.ports.input.CommandHandler
import order.service.application.ports.output.Logger
import order.service.application.ports.output.OrderRepository

class CreateOrderHandler(
    private val repository: OrderRepository,
    private val logger: Logger
) : CommandHandler<CreateOrder> {

    override suspend fun handle(command: CreateOrder) {
        val event = Order.create(command).also { repository.save(it) }
        logger.info("create-order-handler", "Order with id: ${event.orderId} created")
        // save to database
        // save to outbox
        // return the trackingId
    }
}
