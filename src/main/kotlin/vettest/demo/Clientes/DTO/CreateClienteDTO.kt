package vettest.demo.Clientes.DTO

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty

data class CreateClienteDTO (

    @field:NotEmpty
    var nome : String,

    @field:Email
    var contato: String,

    var animalID : List<Int>? = null,
)