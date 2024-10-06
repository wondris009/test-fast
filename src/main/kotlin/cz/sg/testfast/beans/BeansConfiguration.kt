package cz.sg.testfast.beans

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class BeansConfiguration {

    @Bean
    fun heavyBean(): HeavyBean {
        return HeavyBean()
    }

    @Bean
    fun lightBean(): LightBean {
        return LightBean()
    }
}