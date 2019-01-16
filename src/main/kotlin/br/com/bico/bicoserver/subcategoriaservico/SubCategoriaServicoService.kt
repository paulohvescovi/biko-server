package br.com.bico.bicoserver.subcategoriaservico

interface SubCategoriaServicoService {

    fun all():List<SubCategoriaServico>
    fun byCategoriaId(categoriaId: Long):List<SubCategoriaServico>

}