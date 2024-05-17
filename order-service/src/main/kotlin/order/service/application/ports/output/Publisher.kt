package order.service.application.ports.output

import order.service.application.domain.events.OrderEvent

interface Publisher {
    fun publish(event: OrderEvent)
}
