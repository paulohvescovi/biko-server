package br.com.bico.bicoserver.usuario

import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

interface UsuarioRepository: CrudRepository<Usuario, Long> {
}