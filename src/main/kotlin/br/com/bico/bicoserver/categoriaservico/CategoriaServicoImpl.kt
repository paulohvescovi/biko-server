package br.com.bico.bicoserver.categoriaservico

import org.springframework.stereotype.Service

@Service
class CategoriaServicoImpl(var categoriaData: CategoriaServicoData): CategoriaServicoService {

    override fun all(): List<CategoriaServico> = categoriaData.findAll()

}