val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val jena_core_version: String by project
val jena_arq_version: String by project

plugins {
    application
    kotlin("jvm") version "1.7.10"
}

group = "com.edmondchuc"
version = "0.0.1"
application {
    mainClass.set("com.edmondchuc.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.jena:jena-core:$jena_core_version")
    implementation("org.apache.jena:jena-arq:$jena_arq_version")
    implementation("io.ktor:ktor-server-core-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-netty-jvm:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("io.ktor:ktor-server-tests-jvm:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}