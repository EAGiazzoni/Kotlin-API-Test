package vettest.demo.Clientes

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import vettest.demo.Animal.AnimalService
import vettest.demo.Clientes.Converter.toClienteCreate
import vettest.demo.Clientes.DTO.CreateClienteDTO
import vettest.demo.Clientes.DTO.UpdatedClienteDTO
import vettest.demo.Clientes.Entity.ClienteEntity

@RestController
@RequestMapping("/clientes")
class ClientesController(
    private val clientesService: ClientesService,
    private val animalService: AnimalService
) {

    @GetMapping
    fun getAllClientes(): List<ClienteEntity> {
        return clientesService.getCliente()
    }

    @GetMapping("/{id}")
    fun getClienteById(@PathVariable id: Int): ClienteEntity {
        return clientesService.getClienteById(id) ?: throw Exception("Cliente não encontrado")
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCliente(@RequestBody createClienteDTO: CreateClienteDTO) {
        val cliente = createClienteDTO.toClienteCreate(animalService)
        clientesService.createCliente(cliente)
    }

    @PutMapping("/{id}")
    fun updateCliente(
        @PathVariable id: Int,
        @RequestBody updatedClienteDTO: UpdatedClienteDTO
    ) {
        clientesService.updateCliente(updatedClienteDTO, id)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCliente(@PathVariable id: Int) {
        clientesService.deleteCliente(id)
    }
}