package vettest.demo.Animal.DTO

data class CreateAnimalDTO (
    var nome: String,
    var tipoID: Int? = null,
    var donoID: List<Int>? = null
)