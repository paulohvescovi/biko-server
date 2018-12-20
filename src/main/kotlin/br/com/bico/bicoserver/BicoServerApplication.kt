package br.com.bico.bicoserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BicoServerApplication

fun main(args: Array<String>) {
	runApplication<BicoServerApplication>(*args)
}

