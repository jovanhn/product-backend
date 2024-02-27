package com.example.demo.config

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.security.SecurityRequirement
import io.swagger.v3.oas.models.security.SecurityScheme
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig {

    @Value("\${app.name}")
    lateinit var appName: String

    @Value("\${app.version}")
    lateinit var appVersion: String

    // TODO enable after implementing security
//    @Value("\${engagement-hub.oauth2.well-known-url}")
//    lateinit var wellKnownUrl: String

    val schemaName: String = "openId"

    @Bean
    fun customOpenAPI(): OpenAPI {
        return OpenAPI()
            .info(Info().title(appName).version(appVersion))
            .addSecurityItem(SecurityRequirement().addList(schemaName))
        // TODO enable after implementing security
//            .components(
//                Components()
//                    .addSecuritySchemes(
//                        schemaName,
//                        SecurityScheme()
//                            .type(SecurityScheme.Type.OPENIDCONNECT)
//                            .openIdConnectUrl(wellKnownUrl)
//                    )
//            )
    }
}
