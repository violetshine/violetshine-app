package net.violetshine.app

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.resources.*
import io.ktor.server.engine.handleFailure
import io.ktor.server.resources.*
import io.ktor.server.resources.Resources
import io.ktor.server.http.content.*
import kotlinx.serialization.Serializable

fun Application.configureRouting() {
  // Bug workaround: https://slack-chats.kotlinlang.org/t/8518192/hello-when-i-try-to-make-a-request-on-a-route-that-does-not-
  // Without this, HTTP 404 does not work and a 404 results in an empty
  // page being returned to the client with a 200 status code.
  intercept(ApplicationCallPipeline.Fallback) {
    if (call.isHandled) return@intercept
    val status = call.response.status() ?: HttpStatusCode.NotFound
    call.respond(status)
  }

  routing {
    staticResources("/_", "static") {
      fallback { requestedPath, call ->
        call.respond(HttpStatusCode.NotFound)
      }
    }
  }
}
