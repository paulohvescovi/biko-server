package br.com.bico.bicoserver.categorias

import javax.persistence.*

@Entity(name = "CATEGORIASERVICO")
class CategoriaServico(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ID")
        var id: Long? = null,

        @Column(name = "DESCRICAO")
        var descricao: String? = null
)