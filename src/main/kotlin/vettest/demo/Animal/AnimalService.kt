package vettest.demo.Animal

import org.springframework.stereotype.Service
import vettest.demo.Animal.DTO.UpdateAnimalDTO
import vettest.demo.Animal.Entity.AnimalEntity
import vettest.demo.Animal.Repository.AnimalRepository
import vettest.demo.Clientes.ClientesService
import vettest.demo.Enums.Errors
import vettest.demo.Exceptions.NotFoundException
import vettest.demo.Tipo.TipoService

@Service
class AnimalService(
    val animalRepository: AnimalRepository,
    private val tipoService: TipoService,
    private val clientesService: ClientesService
) {
    fun getAnimal(): List<AnimalEntity> {
        return animalRepository.findAll().toList()
    }

    fun createAnimal(animal : AnimalEntity) {
        animalRepository.save(animal)
    }


    fun updateAnimal(updateAnimal: UpdateAnimalDTO, id: Int) {
        val existeAnimal = animalRepository.findById(id).orElseThrow()

        if (!updateAnimal.nome.isNullOrEmpty()) {
            existeAnimal.nome = updateAnimal.nome
        }

        if (updateAnimal.tipoID != null) {
            val tipoAnimal = tipoService.getTipoById(updateAnimal.tipoID!!)
            existeAnimal.tipo = tipoAnimal
        }

        if (updateAnimal.donoID != null) {
            existeAnimal.donos?.clear()
            val novosDonos = updateAnimal.donoID!!.mapNotNull { donoId ->
                clientesService.getClienteById(donoId)
            }
            existeAnimal.donos?.addAll(novosDonos)
        }

        animalRepository.save(existeAnimal)
    }

    fun getAnimalById(id: Int): AnimalEntity? {
        return animalRepository.findById(id).orElseThrow{NotFoundException(Errors.AnEr404.message.format(id), Errors.AnEr404.code )}
    }

    fun deleteAnimalById(id: Int) {
        if(!animalRepository.existsById(id)){
            throw Exception ("Animal não Localizado")
        }
        animalRepository.deleteById(id)
    }


}

