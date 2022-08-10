package com.edmondchuc.rdf

import MaxSizeLimit
import com.edmondchuc.rdf.routing.configureIsomorphicRouting

import com.edmondchuc.rdf.routing.configureRouting
import io.ktor.server.application.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    install(MaxSizeLimit)
    configureRouting()
    configureIsomorphicRouting()
}