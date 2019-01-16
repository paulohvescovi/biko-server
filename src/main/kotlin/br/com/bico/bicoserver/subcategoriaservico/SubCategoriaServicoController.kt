package br.com.bico.bicoserver.subcategoriaservico

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RequestMapping("/subCategorieService")
@RestController
class SubCategoriaServicoController(var subCategoriaServicoService: SubCategoriaServicoService) {

    @GetMapping("/all")
    fun all(): List<SubCategoriaServico> = subCategoriaServicoService.all()

    @GetMapping("/byCategoriaId")
    fun byCategoriaId(@RequestParam("id") id: Long): List<SubCategoriaServico> = subCategoriaServicoService.byCategoriaId(id)


}