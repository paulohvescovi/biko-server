package br.com.bico.bicoserver.home

import br.com.bico.bicoserver.usuario.Usuario
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/")
@RestController
class HomeController {

    @GetMapping("/home")
    fun test(): Usuario {
        return Usuario(1, "teste@gmail.com", "123", "Paulo VBesvo", "nsadksl")
    }

}