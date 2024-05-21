package order.service.application.ports.input

import order.service.application.commands.Command

interface CommandHandler<T : Command> {
    suspend fun handle(command: T)
}
