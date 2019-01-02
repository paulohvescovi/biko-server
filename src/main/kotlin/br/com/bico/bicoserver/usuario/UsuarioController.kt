package br.com.bico.bicoserver.usuario

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal
import java.util.*

@RequestMapping("/usuario")
@RestController
class UsuarioController(var usuarioRepository:UsuarioRepository) {

    @GetMapping("/teste")
    fun test(): Usuario {


        //pegar usuaro logado
        val authentication = SecurityContextHolder.getContext().authentication
        if (authentication != null && authentication.name != null) {
            println(authentication.name!!)
        }

        val usuario = Usuario()

        usuario.nome = "PAULO HENRIQUE VESCOVI"
        usuario.usuario = "paulo.vescovi@viasoft.com.br"
        usuario.senha = "72hj3gh23672vm3b1jh3h1567x517562"

        usuarioRepository.save(usuario)
        return usuario;
    }

    @GetMapping("/all")
    fun login(): MutableIterable<Usuario> {
        return usuarioRepository.findAll();
    }
}