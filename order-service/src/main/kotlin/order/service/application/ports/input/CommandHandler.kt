package order.service.application.ports.input

import order.service.application.commands.Command

interface CommandHandler<T : Command> {
    fun handle(command: T)
}
