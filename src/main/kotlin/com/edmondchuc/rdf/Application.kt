package com.edmondchuc.rdf

import com.edmondchuc.rdf.plugins.configureMaxSizeLimit
import com.edmondchuc.rdf.plugins.configureSerialization
import com.edmondchuc.rdf.routing.configureIsomorphicRouting

import com.edmondchuc.rdf.routing.configureRouting
import io.ktor.server.application.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    configureMaxSizeLimit()
    configureSerialization()
    configureRouting()
    configureIsomorphicRouting()
}