package com.papsign.ktor.openapigen.route

import com.papsign.ktor.openapigen.OpenAPIGen
import com.papsign.ktor.openapigen.route.path.normal.NormalOpenAPIRoute
import io.ktor.application.*
import io.ktor.routing.routing
import io.ktor.util.pipeline.ContextDsl

@ContextDsl
fun Application.apiRouting(config: NormalOpenAPIRoute.() -> Unit) {
    routing {
        NormalOpenAPIRoute(
            this,
            application.feature(OpenAPIGen).globalModuleProvider
        ).apply(config)
    }
}
