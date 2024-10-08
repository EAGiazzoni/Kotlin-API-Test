package vettest.demo.Clientes.Repository

import org.springframework.data.jpa.repository.JpaRepository
import vettest.demo.Clientes.Entity.ClienteEntity

interface ClienteRepository: JpaRepository<ClienteEntity, Int>