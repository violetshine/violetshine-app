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
  routing {
    staticResources("/_", "static") {
      fallback { requestedPath, call ->
        call.respond(HttpStatusCode.NotFound)
      }
    }
    get("*") {
      call.respond(HttpStatusCode.NotFound)
    }
    post("*") { 
      call.respond(HttpStatusCode.NotFound)
    }
  }
}
