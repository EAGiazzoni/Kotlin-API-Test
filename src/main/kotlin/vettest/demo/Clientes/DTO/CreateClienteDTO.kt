package vettest.demo.Clientes.DTO

data class CreateClienteDTO (
    var nome : String,
    var contato: String,
    var animalID : List<Int>? = null,
)