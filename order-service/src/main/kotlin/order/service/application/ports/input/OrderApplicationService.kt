package order.service.application.ports.input

interface OrderApplicationService {
    // CreateOrderCommand
    fun createOrder()

    // TrackOrderQuery
    fun trackOrder()
}
