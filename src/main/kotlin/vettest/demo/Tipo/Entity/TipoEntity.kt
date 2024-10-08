package vettest.demo.Tipo.Entity

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*
import vettest.demo.Animal.Entity.AnimalEntity

@Entity
@Table(name = "tipos")
data class TipoEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column(nullable = false)
    var nome: String = "",


    @OneToMany(mappedBy = "tipo")
    @JsonBackReference
    val animais: List<AnimalEntity> = mutableListOf()
)
