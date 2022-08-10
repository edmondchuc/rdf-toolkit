package com.edmondchuc.rdf.routing

import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondRedirect("/docs")
        }
    }
    routing {
        static("/api/v1") {
            staticBasePackage = "openapi"
            resource("openapi.yml")
        }
    }
    routing {
        static("/docs") {
            staticBasePackage = "openapi"
            resource("", "index.html")
        }
    }
    routing {
        static("/assets") {
            staticBasePackage = "static"
            resource("favicon-32x32.png")
        }
    }
}
