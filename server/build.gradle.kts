plugins {
  alias(libs.plugins.kotlin.jvm)
  alias(ktorLibs.plugins.ktor)
  alias(libs.plugins.kotlin.serialization)

  // Servlet
  id("org.gretty") version "5.0.2"
  id("war")
}

application {
  mainClass = "io.ktor.server.tomcat.jakarta.EngineMain"
}

val copyWebDistCSSToServerResources by tasks.registering(Copy::class) {
  description = "Copies the CSS from the :web project's output to the server's static resources."
  dependsOn(project(":web").tasks.named("jsBrowserDistribution"))
  from(project(":web").layout.buildDirectory.dir("dist/js/productionExecutable"))
  include("**/*.css", "**/*.css.map")
  into(layout.buildDirectory.dir("resources/main/static/css"))
}

val copyWebDistJSToServerResources by tasks.registering(Copy::class) {
  description = "Copies the JavaScript from the :web project's output to the server's static resources."
  dependsOn(project(":web").tasks.named("jsBrowserDistribution"))
  from(project(":web").layout.buildDirectory.dir("dist/js/productionExecutable"))
  include("**/*.js", "**/*.mjs", "**/*.js.map", "**/*.mjs.map")
  into(layout.buildDirectory.dir("resources/main/static/js"))
}

tasks.named("processResources") {
  dependsOn(copyWebDistCSSToServerResources)
  dependsOn(copyWebDistJSToServerResources)
}

kotlin {
  jvmToolchain(25)
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
