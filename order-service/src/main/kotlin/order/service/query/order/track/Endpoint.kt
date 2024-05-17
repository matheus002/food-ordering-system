package order.service.query.order.track

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/v1/track")
class Endpoint() {
    @GetMapping("/{trackingId}")
    fun get(
        @PathVariable trackingId: UUID,
    ): Response? {
        return null
    }
}
