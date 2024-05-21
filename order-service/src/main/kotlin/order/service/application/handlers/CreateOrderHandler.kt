package order.service.application.handlers

import order.service.application.commands.CreateOrder
import order.service.application.domain.models.Order
import order.service.application.ports.input.CommandHandler
import order.service.application.ports.output.OrderRepository

class CreateOrderHandler(
    private val repository: OrderRepository,
) : CommandHandler<CreateOrder> {

    override suspend fun handle(command: CreateOrder) {
        val event = Order.create(command).also { repository.save(it) }
        return event.
        // save to database
        // save to outbox
        // return the trackingId
    }
}
