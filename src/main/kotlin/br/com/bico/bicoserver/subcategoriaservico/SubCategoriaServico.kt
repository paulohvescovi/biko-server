package br.com.bico.bicoserver.subcategoriaservico

import br.com.bico.bicoserver.categoriaservico.CategoriaServico
import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity(name = "SUBCATEGORIASERVICO")
class SubCategoriaServico(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ID")
        var id: Long? = null,

        @Column(name = "DESCRICAO")
        var descricao: String? = null,

        @ManyToOne
        @JoinColumn(name = "CATEGORIAID")
        @JsonIgnore
        var categoria: CategoriaServico? = null
)