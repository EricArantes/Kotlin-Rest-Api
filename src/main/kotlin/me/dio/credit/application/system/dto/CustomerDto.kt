package me.dio.credit.application.system.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.credit.application.system.entity.Address
import me.dio.credit.application.system.entity.Customer
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerDto (
    @field:NotEmpty(message = "empty first name") val firstName: String,
    @field:NotEmpty(message = "empty last name") val lastName: String,
    @field:NotEmpty(message = "empty cpf")
    @field:CPF(message = "invalid cpf")
    val cpf: String,
    @field:NotNull(message = "empty income") val income: BigDecimal,
    @field:NotEmpty(message = "empty email")
    @field:Email(message = "invalid email")
    val email: String,
    @field:NotEmpty(message = "empty password") val password: String,
    @field:NotEmpty(message = "empty zipcode") val zipCode: String,
    @field:NotEmpty(message = "empty street") val street: String

) {
    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        income = this.income,
        email = this.email,
        password = this.password,
        address = Address(
            zipCode = this.zipCode,
            street = this.street
        )


    )
}
