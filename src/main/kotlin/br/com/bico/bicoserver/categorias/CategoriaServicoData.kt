package br.com.bico.bicoserver.categorias

import org.springframework.data.jpa.repository.JpaRepository

interface CategoriaServicoData: JpaRepository<CategoriaServico, Long> {
}