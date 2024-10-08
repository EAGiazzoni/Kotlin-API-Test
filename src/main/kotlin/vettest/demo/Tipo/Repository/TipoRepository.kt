package vettest.demo.Tipo.Repository

import org.springframework.data.jpa.repository.JpaRepository
import vettest.demo.Tipo.Entity.TipoEntity

interface TipoRepository: JpaRepository<TipoEntity, Int>