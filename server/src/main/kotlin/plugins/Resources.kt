package net.violetshine.app.plugins

import io.ktor.server.application.*
import io.ktor.server.resources.*

fun Application.configureResources() {
  install(Resources)
}
