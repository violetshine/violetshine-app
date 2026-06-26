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

val copyFrontendDistCSSToServerResources by tasks.registering(Copy::class) {
  description = "Copies the CSS from the :frontend project's output to the app's static resources."
  dependsOn(project(":frontend").tasks.named("jsBrowserDistribution"))
  from(project(":frontend").layout.buildDirectory.dir("dist/js/productionExecutable"))
  include("**/*.css", "**/*.css.map")
  into(layout.buildDirectory.dir("resources/main/static/css"))
}

val copyFrontendDistJSToServerResources by tasks.registering(Copy::class) {
  description = "Copies the JavaScript from the :frontend project's output to the app's static resources."
  dependsOn(project(":frontend").tasks.named("jsBrowserDistribution"))
  from(project(":frontend").layout.buildDirectory.dir("dist/js/productionExecutable"))
  include("**/*.js", "**/*.mjs", "**/*.js.map", "**/*.mjs.map")
  into(layout.buildDirectory.dir("resources/main/static/js"))
}

tasks.named("processResources") {
  dependsOn(copyFrontendDistCSSToServerResources)
  dependsOn(copyFrontendDistJSToServerResources)
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

  // https://github.com/Kotlin/kotlinx-datetime
  implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.8.0")

  testImplementation(kotlin("test"))
  testImplementation(ktorLibs.server.testHost)
}
