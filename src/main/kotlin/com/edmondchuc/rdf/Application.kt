package com.edmondchuc.rdf

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.edmondchuc.rdf.plugins.*
import com.edmondchuc.rdf.plugins.configureRouting

fun main() {
    // TODO: Fix auto-reload...
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", watchPaths = listOf("classes")) {
        configureRouting()
    }.start(wait = true)
}
