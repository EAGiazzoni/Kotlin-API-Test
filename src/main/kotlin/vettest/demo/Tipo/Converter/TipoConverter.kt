package vettest.demo.Tipo.Converter

import vettest.demo.Tipo.DTO.CreateTipoDTO
import vettest.demo.Tipo.DTO.UpdateTipoDTO
import vettest.demo.Tipo.Entity.TipoEntity

fun CreateTipoDTO.toTipoCreate(): TipoEntity{
    return TipoEntity(nome = this.nome)
}

fun UpdateTipoDTO.toTipoUpdated(id: Int): TipoEntity{
    return TipoEntity(id = id, nome = this.nome)
}