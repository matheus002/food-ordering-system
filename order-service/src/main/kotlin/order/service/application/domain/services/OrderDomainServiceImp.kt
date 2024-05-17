package order.service.application.domain.services

import order.service.application.domain.events.CancelEvent
import order.service.application.domain.events.OrderCancelled
import order.service.application.domain.events.OrderCreated
import order.service.application.domain.events.OrderPaid
import order.service.application.domain.exceptions.OrderDomainException
import order.service.application.domain.models.OrderOrquestration
import order.service.application.domain.models.Restaurant
import order.service.application.domain.models.order.Product
import order.service.application.ports.output.Logger
import java.time.ZoneId
import java.time.ZonedDateTime

class OrderDomainServiceImp(
    private val logger: Logger,
) : OrderDomainService {
    private val identifier = "order-domain-service"
    private val zoneId: ZoneId = ZoneId.of("UTC")

    override fun validateAndInitiateOrder(
        order: OrderOrquestration,
        restaurant: Restaurant,
    ): OrderCreated {
        validateRestaurant(restaurant)
        setOrderProductInformation(order, restaurant)
        order.validateOrder()
        order.initializeOrder()
        logger.info(identifier, "Order with id: ${order.orderId} is initiated")
        return OrderCreated(order, ZonedDateTime.now(zoneId))
    }

    override fun payOrder(order: OrderOrquestration): OrderPaid {
        order.pay()
        logger.info(identifier, "Order with id: ${order.orderId} is payed")
        return OrderPaid(order, ZonedDateTime.now(zoneId))
    }

    override fun approveOrder(order: OrderOrquestration) {
        order.approve()
        logger.info(identifier, "Order with id: ${order.orderId} is approved")
    }

    override fun cancelOrderPayment(
        order: OrderOrquestration,
        failureMessages: List<String>,
    ): CancelEvent {
        order.initCancel(failureMessages)
        logger.info(identifier, "Order with id: ${order.orderId} is in cancellation process")
        return OrderCancelled(order, ZonedDateTime.now(zoneId))
    }

    override fun cancelOrder(
        order: OrderOrquestration,
        failureMessages: List<String>,
    ) {
        order.cancel(failureMessages)
        logger.info(identifier, "Order with id: ${order.orderId} is cancelled")
    }

    private fun validateRestaurant(restaurant: Restaurant) {
        if (!restaurant.active) {
            throw OrderDomainException("The Restaurant with id: ${restaurant.restaurantId} is not active")
        }
    }

    private fun setOrderProductInformation(
        order: OrderOrquestration,
        restaurant: Restaurant,
    ) {
        order.items.forEach { item ->
            run {
                restaurant.products.forEach { restaurantProduct ->
                    run {
                        val currentProduct: Product = item.product
                        if (currentProduct == restaurantProduct) {
                            currentProduct.updateWithConfirmedNameAndPrice(
                                restaurantProduct.name,
                                restaurantProduct.price,
                            )
                        }
                    }
                }
            }
        }
    }
}
