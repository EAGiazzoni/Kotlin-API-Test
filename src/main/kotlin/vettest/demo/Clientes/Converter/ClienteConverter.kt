package vettest.demo.Clientes.Converter

import vettest.demo.Animal.AnimalService
import vettest.demo.Animal.Entity.AnimalEntity
import vettest.demo.Clientes.DTO.CreateClienteDTO
import vettest.demo.Clientes.DTO.UpdatedClienteDTO
import vettest.demo.Clientes.Entity.ClienteEntity

fun CreateClienteDTO.toClienteCreate(animalService: AnimalService): ClienteEntity {
    val animaisList = animalID?.mapNotNull { animalId ->
        animalService.getAnimalById(animalId)
    }?.toMutableList() ?: mutableListOf()

    return ClienteEntity(
        nome = this.nome,
        contato = this.contato,
        animais = animaisList
    )
}

fun UpdatedClienteDTO.toClienteUpdated(animalService: AnimalService, id: Int): ClienteEntity {
    val animaisList = mutableListOf<AnimalEntity>()
    animalID?.let {
        val animal = animalService.getAnimalById(it)
        if (animal != null) {
            animaisList.add(animal)
        }
    }
    return ClienteEntity(id = id, nome = this.nome, contato = this.contato, animais = animaisList)
}