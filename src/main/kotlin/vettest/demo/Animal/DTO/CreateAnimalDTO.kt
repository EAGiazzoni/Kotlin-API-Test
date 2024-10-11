package vettest.demo.Animal.DTO

import jakarta.validation.constraints.NotEmpty

data class CreateAnimalDTO (
    @field:NotEmpty(message = "Name is required")
    var nome: String,

    var tipoID: Int? = null,
    var donoID: List<Int>? = null
)