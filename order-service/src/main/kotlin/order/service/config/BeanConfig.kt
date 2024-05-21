package order.service.config

import order.service.application.commands.CreateOrder
import order.service.application.handlers.CreateOrderHandler
import order.service.application.ports.input.CommandHandler
import order.service.application.ports.output.Logger
import order.service.driven.LoggerAdapter
import order.service.driven.persistence.PostgreAdapter
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope

@Configuration
class BeanConfig {
//    @Bean
//    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
//    fun logger(): Logger {
//        return LoggerAdapter()
//    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    fun createOrder(): CommandHandler<CreateOrder> {
        return CreateOrderHandler(PostgreAdapter(), LoggerAdapter())
    }
}
