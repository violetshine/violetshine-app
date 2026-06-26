plugins {
  alias(libs.plugins.kotlin.multiplatform) apply false
  alias(libs.plugins.kotlin.jvm) apply false
}

subprojects {
  group = "net.violetshine"
  version = "0.1.0-SNAPSHOT"
}

/*
plugins {
  alias(libs.plugins.kotlin.jvm)
  alias(ktorLibs.plugins.ktor)
  alias(libs.plugins.kotlin.serialization)

  // Servlet
  id("org.gretty") version "5.0.2"
  id("war")
}

group = "net.violetshine"
version = "0.1.0-SNAPSHOT"

application {
  mainClass = "io.ktor.server.tomcat.jakarta.EngineMain"
}

kotlin {
  jvmToolchain(25)
}

dependencies {
  implementation(ktorLibs.serialization.kotlinx.json)
  implementation(ktorLibs.server.config.yaml)
  implementation(ktorLibs.server.contentNegotiation)
  implementation(ktorLibs.server.core)
  implementation(ktorLibs.server.htmlBuilder)
  implementation(ktorLibs.server.resources)
  implementation(ktorLibs.server.statusPages)
  implementation(ktorLibs.server.tomcat)
  implementation(libs.kotlinx.kotlinxHtml)
  implementation(libs.logback.classic)

  // Use Ktor in a servlet application with Tomcat
  implementation(ktorLibs.server.servlet)

  testImplementation(kotlin("test"))
  testImplementation(ktorLibs.server.testHost)
}

gretty {
  servletContainer = "tomcat11"
  contextPath = "/"
}

afterEvaluate {
  tasks.getByName("run") {
    dependsOn("appRun")
  }
}
*/