package com.edmondchuc.rdf

import MaxSizeLimit

import com.edmondchuc.rdf.plugins.configureRouting
import io.ktor.server.application.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    install(MaxSizeLimit)
    configureRouting()
}