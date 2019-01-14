package br.com.bico.bicoserver.usuario

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/usuario")
@RestController
class UsuarioController(var usuarioService: UsuarioService) {

    @GetMapping("/usuario")
    fun usuarioLogado(): Usuario {
        return usuarioService.getUsuarioLogado()
    }


}