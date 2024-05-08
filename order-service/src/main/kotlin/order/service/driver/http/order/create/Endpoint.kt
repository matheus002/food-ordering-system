package order.service.driver.http.order.create

import order.service.application.ports.out.Logger
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/create")
class Endpoint(
    private val logger: Logger
) {

    @PostMapping
    suspend fun create(@RequestBody request: Request): ResponseEntity<String> {
        logger.info("request-handler", "Request received for endpoint /create: $request")
        return ResponseEntity.noContent().build()
    }
}