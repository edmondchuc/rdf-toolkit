import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*

val MaxSizeLimit = createApplicationPlugin(name = "MaxSizeLimit") {
    onCallReceive { call ->
        val maxSize =
            call.application.environment.config.property("ktor.plugins.MaxSizeLimit.value").getString().toLong()
        val contentLength = call.request.headers["Content-Length"]?.toLong() ?: 0

        if (contentLength > maxSize) {
            call.respond(HttpStatusCode.PayloadTooLarge)
            return@onCallReceive
        }
    }
}