package vettest.demo.Clientes

import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Service
import vettest.demo.Animal.AnimalService
import vettest.demo.Animal.Entity.AnimalEntity
import vettest.demo.Clientes.DTO.CreateClienteDTO
import vettest.demo.Clientes.DTO.UpdatedClienteDTO
import vettest.demo.Clientes.Entity.ClienteEntity
import vettest.demo.Clientes.Repository.ClienteRepository
import vettest.demo.Enums.Errors
import vettest.demo.Exceptions.NotFoundException

@Service
class ClientesService (
    val clienteRepository: ClienteRepository,
    @Lazy private val animalService: AnimalService
){

    fun getCliente(): List<ClienteEntity> {
        return clienteRepository.findAll().toList()
    }

    fun createCliente(cliente: ClienteEntity) {
        clienteRepository.save(cliente)
    }

    fun updateCliente(updatedCliente: UpdatedClienteDTO, id: Int) {
        val clienteReal = clienteRepository.findById(id).orElseThrow { Exception("Cliente não encontrado") }

        if (!updatedCliente.nome.isNullOrEmpty()) {
            clienteReal.nome = updatedCliente.nome
        }

        if (!updatedCliente.contato.isNullOrEmpty()) {
            clienteReal.contato = updatedCliente.contato
        }

        if (updatedCliente.animalID != null) {
            val animal = animalService.getAnimalById(updatedCliente.animalID!!)
            if (animal != null) {
                clienteReal.animais?.add(animal)
            } else {
                throw Exception("Animal com ID ${updatedCliente.animalID} não encontrado")
        }
        clienteRepository.save(clienteReal)
        }
    }

    fun getClienteById(id: Int): ClienteEntity? {
        return clienteRepository.findById(id).orElseThrow{ NotFoundException(Errors.ClEr404.message.format(id), Errors.ClEr404.code ) }
    }

    fun deleteCliente(id: Int) {
        if(!clienteRepository.existsById(id)){
            throw Exception("Cliente não localizado")
        }
        clienteRepository.deleteById(id)
    }
}