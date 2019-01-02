package br.com.bico.bicoserver.usuario

import javax.persistence.*
import javax.validation.constraints.Size

@Entity
data class Usuario (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column
    var nome: String? = null,

    @Column
    var usuario: String? = null,

    @Column
    @Size(min = 5, max = 60)
    var senha: String? = null,

    @Column
    var email: String? = null


)