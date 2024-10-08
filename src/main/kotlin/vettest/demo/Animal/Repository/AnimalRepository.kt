package vettest.demo.Animal.Repository

import org.springframework.data.jpa.repository.JpaRepository
import vettest.demo.Animal.Entity.AnimalEntity

interface AnimalRepository : JpaRepository<AnimalEntity, Int>