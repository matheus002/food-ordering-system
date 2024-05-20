package order.service.application.handlers

import order.service.application.commands.CreateOrder
import order.service.application.domain.models.OrderOrquestration
import order.service.application.ports.input.CommandHandler

class CreateOrderHandler() : CommandHandler<CreateOrder> {
    override fun handle(command: CreateOrder) {
        val event =
            OrderOrquestration(
                customerId = command.customerId,
                restaurantId = command.restaurantId,
                deliveryAddress = command.deliveryAddress,
                items = command.items,
            ).initializeOrder()
        // create the event for the Order
        // save to the database
        // save to outbox table
    }
}
