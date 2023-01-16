package felu.io.felubackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FeluBackendApplication

fun main(args: Array<String>) {
	runApplication<FeluBackendApplication>(*args)
}
