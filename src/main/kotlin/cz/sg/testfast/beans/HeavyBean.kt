package cz.sg.testfast.beans

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.stereotype.Service

@Service
class HeavyBean {
    init {
        log.info { "Beginning construction..." }
        try {
            Thread.sleep(2000)
        } catch (ignored: InterruptedException) {
        }
        log.info { "Construction complete" }
    }
}

private val log = KotlinLogging.logger {}