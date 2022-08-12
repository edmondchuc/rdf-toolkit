package com.edmondchuc.rdf

import com.edmondchuc.rdf.plugins.configureMaxSizeLimit
import com.edmondchuc.rdf.plugins.configureSerialization
import com.edmondchuc.rdf.routing.configureIsomorphicRouting

import com.edmondchuc.rdf.routing.configureRouting
import com.typesafe.config.ConfigFactory
import io.ktor.server.application.*
import io.ktor.server.cio.*
import io.ktor.server.config.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main(args: Array<String>) {
    embeddedServer(CIO, environment = applicationEngineEnvironment {
//        log = LoggerFactory.getLogger("ktor.application")
        config = HoconApplicationConfig(ConfigFactory.load())

        connector {
            port = 8080
            host = "0.0.0.0"
        }
    }).start(wait = true)
}

fun Application.module() {
    configureMaxSizeLimit()
    configureSerialization()
    configureRouting()
    configureIsomorphicRouting()
}