package br.com.bico.bicoserver.usuario

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity(name = "USUARIO")
data class Usuario (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    var id: Long? = null,

    @Column(name = "EMAIL")
    var email: String? = null,

    @JsonIgnore
    @Column(name = "SENHA")
    var senha: String? = null,

    @Column(name = "NOME")
    var nome: String? = null,

    @Column(name = "SOBRENOME")
    var sobrenome: String? = null
)