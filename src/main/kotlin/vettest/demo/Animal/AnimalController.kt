package vettest.demo.Animal

import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*
import vettest.demo.Animal.Converter.toAnimalCreate
import vettest.demo.Animal.DTO.CreateAnimalDTO
import vettest.demo.Animal.DTO.UpdateAnimalDTO
import vettest.demo.Animal.Entity.AnimalEntity
import vettest.demo.Clientes.ClientesService
import vettest.demo.Tipo.TipoService

@RestController
@RequestMapping("/animais")
class AnimalController(
    val animalService: AnimalService,
    private val tipoService: TipoService,
    private val clienteService: ClientesService
)
{
    @GetMapping
    fun getAll(): List<AnimalEntity> {
        return animalService.getAnimal()
    }
    @GetMapping("/{id}")
    fun getAnimalById(@PathVariable("id") id: Int): AnimalEntity? {
        return animalService.getAnimalById(id)
    }

    @PostMapping
    fun postAnimal(@RequestBody @Valid animal: CreateAnimalDTO) {
        animalService.createAnimal(animal.toAnimalCreate(tipoService, clienteService))
    }

    @PutMapping("/{id}")
    fun putAnimal(@PathVariable("id") id: Int, @RequestBody animal: UpdateAnimalDTO) {
        animalService.updateAnimal(animal, id)
    }

    @DeleteMapping("/{id}")
    fun deleteAnimal(@PathVariable("id") id: Int) {
        animalService.deleteAnimalById(id)
    }

}