package vettest.demo.Tipo

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import vettest.demo.Tipo.Converter.toTipoCreate
import vettest.demo.Tipo.Converter.toTipoUpdated
import vettest.demo.Tipo.DTO.CreateTipoDTO
import vettest.demo.Tipo.DTO.UpdateTipoDTO
import vettest.demo.Tipo.Entity.TipoEntity

@RestController
@RequestMapping("/tipos")
class TipoController (
    val tipoService: TipoService
)
{
    @GetMapping
    fun getAll() : List<TipoEntity> {
        return tipoService.getTipos()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun postTipo(@RequestBody tipo: CreateTipoDTO) {
        tipoService.createTipo(tipo.toTipoCreate())
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id: Int): TipoEntity {
        return tipoService.getTipoById(id)
    }

    @PutMapping("/{id}")
    fun put(@PathVariable("id") id: Int, @RequestBody updateTipo: UpdateTipoDTO) {
        tipoService.updateTipo(updateTipo.toTipoUpdated(id))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Int) {
        tipoService.deleteTipo(id)
    }


}