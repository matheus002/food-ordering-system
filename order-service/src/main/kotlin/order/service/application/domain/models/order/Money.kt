package order.service.application.domain.models.order

import java.math.BigDecimal
import java.math.RoundingMode

data class Money(val amount: BigDecimal){

    fun isGreaterThanZero(): Boolean {
        return this.amount.compareTo(BigDecimal.ZERO) > 0
    }

    fun idGreaterThan(money: Money): Boolean {
        return this.amount.compareTo(money.amount) > 0
    }

    fun add(money: Money): Money {
        return Money(setScale(this.amount.add(money.amount)))
    }

    fun subtract(money: Money): Money {
        return Money(setScale(this.amount.subtract(money.amount)))
    }

    fun multiply(multiplier: Int): Money {
        return Money(setScale(this.amount.multiply(BigDecimal(multiplier))))
    }

    private fun setScale(input: BigDecimal): BigDecimal {
        return input.setScale(2, RoundingMode.HALF_EVEN)
    }
}