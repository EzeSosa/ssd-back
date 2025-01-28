package com.esosa.ssdbackend.config

import com.esosa.ssdbackend.config.WebConfig.CorsConstants.HEADERS
import com.esosa.ssdbackend.config.WebConfig.CorsConstants.METHODS
import com.esosa.ssdbackend.config.WebConfig.CorsConstants.ORIGIN
import com.esosa.ssdbackend.config.WebConfig.CorsConstants.PATH_PATTERN
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig: WebMvcConfigurer {

    object CorsConstants {
        const val PATH_PATTERN = "/**"
        const val ORIGIN = "http://localhost:4200"
        const val METHODS = "GET"
        const val HEADERS = "*"
    }

    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping(PATH_PATTERN)
            .allowedOrigins(ORIGIN)
            .allowedMethods(METHODS)
            .allowedHeaders(HEADERS)
            .allowCredentials(true)
    }
}