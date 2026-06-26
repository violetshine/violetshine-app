package net.violetshine.app.plugins

import io.ktor.server.application.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation

fun Application.configureSerialisation() {
  install(ContentNegotiation) {
    json()
  }
}
