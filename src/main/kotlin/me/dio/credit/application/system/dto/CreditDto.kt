package me.dio.credit.application.system.dto

import jakarta.validation.constraints.Future
import jakarta.validation.constraints.NotNull
import me.dio.credit.application.system.entity.Credit
import me.dio.credit.application.system.entity.Customer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    @field:NotNull(message = "empty credit value")val creditValue: BigDecimal,
    @field:Future(message = "first installment must be in the future") val dayFirstInstallment: LocalDate,
    @field:NotNull(message = "empty number of installments") val numberOfInstallment: Int,
    @field:NotNull(message = "empty customer id") val customerId: Long,
) {

    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstInstallment,
        numberOfInstallment = this.numberOfInstallment,
        customer = Customer(id = this.customerId)

    )


}
