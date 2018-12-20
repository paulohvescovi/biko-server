package br.com.bico.bicoserver.usuario

import javax.persistence.*

@Entity
data class Usuario (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column
    var nome: String? = null,

    @Column
    var usuario: String? = null,

    @Column
    var senha: String? = null


)