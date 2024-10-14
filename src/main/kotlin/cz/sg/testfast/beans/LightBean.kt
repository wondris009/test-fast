package cz.sg.testfast.beans

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.stereotype.Service

@Service
class LightBean {

    init {
        log.info { "Beginning construction..." }
        try {
            Thread.sleep(100)
        } catch (ignored: InterruptedException) {
        }
        log.info { "Construction complete" }
    }
}

private val log = KotlinLogging.logger {}