package cz.sg.testfast.services

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.stereotype.Service


@Service
class DataListService {
    init {
        logger.info { "Beginning construction..." }
        try {
            Thread.sleep(1000)
        } catch (ignored: InterruptedException) {
        }
        logger.info { "Construction complete" }
    }

    fun get(): List<String> {
        return mutableListOf("A", "B", "C")
    }
}

private val logger = KotlinLogging.logger {}