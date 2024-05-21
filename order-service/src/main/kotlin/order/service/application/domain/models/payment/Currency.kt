package order.service.application.domain.models.payment

enum class Currency(
    val id: Long,
) {
    BRL(1),
    USD(2),
    ;

    companion object {
        fun of(id: Long): Currency =
            entries
                .firstOrNull { it.id == id }
                ?: throw IllegalArgumentException("Currency not found for the order payment provided")
    }
}
