package br.com.bico.bicoserver.usuario

import org.springframework.security.core.userdetails.UserDetailsService

interface UsuarioService: UserDetailsService {

    fun getUsuarioLogado():Usuario

}