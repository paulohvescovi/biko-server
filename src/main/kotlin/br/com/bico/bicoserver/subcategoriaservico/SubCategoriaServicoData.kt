package br.com.bico.bicoserver.subcategoriaservico

import org.springframework.data.jpa.repository.JpaRepository

interface SubCategoriaServicoData: JpaRepository<SubCategoriaServico, Long> {

    fun findByCategoriaId(categoriaId: Long):List<SubCategoriaServico>

}