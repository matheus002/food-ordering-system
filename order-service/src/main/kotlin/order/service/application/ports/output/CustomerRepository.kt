package order.service.application.ports.output

import order.service.application.domain.models.Customer
import java.util.UUID

interface CustomerRepository {
    fun findCustomerById(id: UUID): Customer?
}
