package br.com.bico.bicoserver.categoriaservico

import org.springframework.data.jpa.repository.JpaRepository

interface CategoriaServicoData: JpaRepository<CategoriaServico, Long> {
}