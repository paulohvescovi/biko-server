package br.com.bico.bicoserver.configuration.jwt

data class UserCredentials(val email:String? = null,
                           val senha:String? = null)