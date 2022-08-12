package com.edmondchuc.rdf.routing

import com.edmondchuc.rdf.isomorphic
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable

@Serializable
data class IsomorphicInput(val graphOneData: String, val graphTwoData: String, val graphOneFormat: String, val graphTwoFormat: String)

fun Application.configureIsomorphicRouting() {
    routing {
        post("/api/v1/isomorphic") {
            // TODO: Error handling
            val input = call.receive<IsomorphicInput>()
            val isomorphic = isomorphic(input.graphOneData, input.graphOneFormat, input.graphTwoData, input.graphTwoFormat)
            call.respondText("""{"isomorphic": $isomorphic }""", ContentType.Application.Json)
        }
    }
}