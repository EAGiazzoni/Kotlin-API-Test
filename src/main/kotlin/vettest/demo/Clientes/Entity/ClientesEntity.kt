package vettest.demo.Clientes.Entity

import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*
import vettest.demo.Animal.Entity.AnimalEntity


@Entity
@Table(name = "clientes")
data class ClienteEntity (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column
    var nome: String? = "",

    @Column
    var contato: String? = "",

    @ManyToMany
    @JoinTable(
        name = "cliente_animal",
        joinColumns = [JoinColumn(name = "cliente_id")],
        inverseJoinColumns = [JoinColumn(name = "animal_id")]
    )
    @JsonManagedReference
    val animais: MutableList<AnimalEntity>? = mutableListOf()
)