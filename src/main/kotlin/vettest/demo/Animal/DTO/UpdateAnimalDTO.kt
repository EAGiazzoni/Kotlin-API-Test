package vettest.demo.Animal.DTO

data class UpdateAnimalDTO (
    var nome: String? = "",
    var tipoID: Int? = null,
    var donoID: List<Int>? = null
)