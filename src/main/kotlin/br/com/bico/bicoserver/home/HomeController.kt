package br.com.bico.bicoserver.home

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/")
@RestController
class HomeController {

    @GetMapping("/home")
    fun test(): String {
        return "HOME PAGE"
    }
}