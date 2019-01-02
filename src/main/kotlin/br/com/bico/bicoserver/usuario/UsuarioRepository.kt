package br.com.bico.bicoserver.usuario

import org.springframework.data.repository.CrudRepository

interface UsuarioRepository: CrudRepository<Usuario, Long> {

    fun findByEmail(email:String):Usuario

}