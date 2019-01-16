package br.com.bico.bicoserver.subcategoriaservico

import org.springframework.stereotype.Service

@Service
class SubCategoriaServicoServiceImpl(var subCategoriaData: SubCategoriaServicoData): SubCategoriaServicoService {

    override fun all(): List<SubCategoriaServico> = subCategoriaData.findAll()

    override fun byCategoriaId(categoriaId: Long): List<SubCategoriaServico> = subCategoriaData.findByCategoriaId(categoriaId)

}