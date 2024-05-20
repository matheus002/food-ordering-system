package order.service.application.domain.events

import order.service.application.domain.models.Version

sealed interface Event {
    val version: Version
}
