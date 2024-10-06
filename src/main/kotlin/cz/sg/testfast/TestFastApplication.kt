package cz.sg.testfast

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TestFastApplication

fun main(args: Array<String>) {
    runApplication<TestFastApplication>(*args)
}
