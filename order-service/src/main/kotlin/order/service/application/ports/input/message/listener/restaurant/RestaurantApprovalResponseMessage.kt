package order.service.application.ports.input.message.listener.restaurant

import order.service.driver.http.RestaurantApprovalResponse

interface RestaurantApprovalResponseMessage {
    fun orderApproved(restaurantApprovalResponse: RestaurantApprovalResponse)

    fun orderRejected(restaurantApprovalResponse: RestaurantApprovalResponse)
}
