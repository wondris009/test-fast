package cz.sg.testfast.services

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.stereotype.Service

@Service
class DataByIdService {
    init {
        logger.info { "Beginning construction..." }
        try {
            Thread.sleep(1000)
        } catch (ignored: InterruptedException) {
        }
        logger.info { "Construction complete" }
    }

    fun get(id: String): String {
        return id
    }
}

private val logger = KotlinLogging.logger {}