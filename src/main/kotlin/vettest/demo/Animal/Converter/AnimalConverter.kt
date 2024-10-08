package vettest.demo.Animal.Converter

import vettest.demo.Animal.DTO.CreateAnimalDTO
import vettest.demo.Animal.DTO.UpdateAnimalDTO
import vettest.demo.Animal.Entity.AnimalEntity
import vettest.demo.Clientes.ClientesService
import vettest.demo.Tipo.TipoService

fun CreateAnimalDTO.toAnimalCreate(tipoService: TipoService, clienteService: ClientesService): AnimalEntity {
    val tipoEntity = tipoID?.let { tipoService.getTipoById(it) }

    val donosList = donoID?.mapNotNull { donoId ->
        clienteService.getClienteById(donoId)
    }?.toMutableList() ?: mutableListOf()

    return AnimalEntity(
        nome = this.nome,
        tipo = tipoEntity,
        donos = donosList
    )
}

fun UpdateAnimalDTO.toAnimalUpdated(tipoService: TipoService, id: Int): AnimalEntity {
    val tipoEntity = tipoID?.let { tipoService.getTipoById(it) }
    return AnimalEntity(id = id, nome = this.nome, tipo = tipoEntity)
}