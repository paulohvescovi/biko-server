package br.com.bico.bicoserver.usuario

import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioData: JpaRepository<Usuario, Long> {

    fun findByEmail(email:String):Usuario

}