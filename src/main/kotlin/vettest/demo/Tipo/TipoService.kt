package vettest.demo.Tipo

import org.springframework.stereotype.Service
import vettest.demo.Tipo.Entity.TipoEntity
import vettest.demo.Tipo.Repository.TipoRepository

@Service
class TipoService (
    val tipoRepository: TipoRepository
){
    fun getTipos(): List<TipoEntity> {
        return tipoRepository.findAll().toList()
    }
    fun createTipo(tipo: TipoEntity) {
        tipoRepository.save(tipo)
    }

    fun updateTipo(updateTipo: TipoEntity) {
        if (!tipoRepository.existsById(updateTipo.id!!)){
            throw Exception("Tipo não Localizado")
        }
        tipoRepository.save(updateTipo)
    }

    fun getTipoById(id: Int): TipoEntity {
        return tipoRepository.findById(id).orElseThrow()
    }
    fun deleteTipo (id: Int) {
        if(!tipoRepository.existsById(id)){
            throw Exception("Tipo não localizado")
        }
        tipoRepository.deleteById(id)
    }
}