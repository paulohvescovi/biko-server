package br.com.bico.bicoserver.categoriaservico

import br.com.bico.bicoserver.subcategoriaservico.SubCategoriaServico
import javax.persistence.*

@Entity(name = "CATEGORIASERVICO")
class CategoriaServico(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ID")
        var id: Long? = null,

        @Column(name = "DESCRICAO")
        var descricao: String? = null,

        @OneToMany(mappedBy = "categoria", fetch = FetchType.EAGER, cascade = arrayOf(CascadeType.ALL), orphanRemoval = false)
        var subCategoriaList: MutableList<SubCategoriaServico>,

        @Column(name = "DESCRICAODETALHADA")
        var descricaoDetalhada: String? = null,

        @Column(name = "IMAGEURL")
        var imageUrl: String? = null



)
