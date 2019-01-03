package br.com.bico.bicoserver.usuario

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UsuarioServiceImpl(var usuarioData: UsuarioData): UsuarioService {

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(login: String): UserDetails {
        val usuario = usuarioData.findByEmail(login)
        return if (usuario != null) {
            User.withUsername(usuario.email)
                    .password(usuario.senha!!)
                    .roles("CLIENT").build()
        } else {
            throw UsernameNotFoundException("Não foi possível encontrar o usuário $login")
        }
    }

    override fun getUsuarioLogado(): Usuario {
        val authentication = SecurityContextHolder.getContext().authentication
        if (authentication != null && authentication.name != null) {
            return usuarioData.findByEmail(authentication.name)
        }
        //TODO mudar para pegar o id de um properties, pois pode ser o 1 ou o 100
        return usuarioData.findById(1).get()
    }
}