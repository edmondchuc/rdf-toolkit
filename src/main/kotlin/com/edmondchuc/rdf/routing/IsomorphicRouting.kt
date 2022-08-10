package com.edmondchuc.rdf.routing

import com.edmondchuc.rdf.isomorphic
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.io.IOException

fun Application.configureIsomorphicRouting() {
    routing {
        post("/api/v1/isomorphic") {
            var graphOneData = ""
            var graphOneFormat = ""
            var graphTwoData = ""
            var graphTwoFormat = ""

            try {
                val multipartData = call.receiveMultipart()
                multipartData.forEachPart { part ->
                    when (part) {
                        is PartData.FormItem -> {
                            when (part.name) {
                                "graphOneData" -> graphOneData = part.value
                                "graphOneFormat" -> graphOneFormat = part.value
                                "graphTwoData" -> graphTwoData = part.value
                                "graphTwoFormat" -> graphTwoFormat = part.value
                            }
                        }

                        else -> {
                            call.respondText("Unsupported part type: ${part.javaClass}")
                        }
                    }
                }
            } catch (e: IOException) {
                call.respondText("Failed to read multipart form data: ${e.message}", status = HttpStatusCode.BadRequest)
            }

            if (graphOneData.isEmpty()) {
                call.respondText("Missing parameter 'graphOneData'", status = HttpStatusCode.BadRequest)
            }
            if (graphOneFormat.isEmpty()) {
                call.respondText("Missing parameter 'graphOneFormat'", status = HttpStatusCode.BadRequest)
            }
            if (graphTwoData.isEmpty()) {
                call.respondText("Missing parameter 'graphTwoData'", status = HttpStatusCode.BadRequest)
            }
            if (graphTwoFormat.isEmpty()) {
                call.respondText("Missing parameter 'graphTwoFormat'", status = HttpStatusCode.BadRequest)
            }

            try {
                val isomorphic = isomorphic(graphOneData, graphOneFormat, graphTwoData, graphTwoFormat)
                call.respondText("""{"isomorphic": $isomorphic }""", ContentType.Application.Json)
            } catch (e: Exception) {
                call.respondText("${e.message}", status = HttpStatusCode.BadRequest)
            }
        }
    }
}