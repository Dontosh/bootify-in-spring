package no.rubstein.bootone

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BootoneApplication

fun main(args: Array<String>) {
	runApplication<BootoneApplication>(*args)
}
