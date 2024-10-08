package vettest.demo.Animal.Entity

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*
import vettest.demo.Clientes.Entity.ClienteEntity
import vettest.demo.Tipo.Entity.TipoEntity

@Entity
@Table(name = "animais")
data class AnimalEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column(nullable = false)
    var nome: String? = "",


    @ManyToOne
    @JoinColumn(name = "tipo_id")
    @JsonManagedReference
    var tipo: TipoEntity? = null,

    @ManyToMany(mappedBy = "animais", cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    @JsonBackReference
    val donos: MutableList<ClienteEntity>? = mutableListOf()
)