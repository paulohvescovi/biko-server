package br.com.bico.bicoserver.usuario

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/usuario")
@RestController
class UsuarioController {

    @GetMapping("/teste")
    fun test(): Usuario {
        val usuario = Usuario()
        usuario.id = 1
        usuario.nome = "PAULO HENRIQUE VESCOVI"
        usuario.usuario = "paulo.vescovi@viasoft.com.br"
        usuario.senha = "72hj3gh23672vm3b1jh3h1567x517562"
        return usuario;
    }

}