package br.com.bico.bicoserver.categorias

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/categorieService")
@RestController
class CategoriaServicoController(var categoriaServicoService: CategoriaServicoService) {

    @GetMapping("/all")
    fun all(): List<CategoriaServico> = categoriaServicoService.all()


}