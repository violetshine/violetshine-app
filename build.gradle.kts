plugins {
  alias(libs.plugins.kotlin.multiplatform) apply false
  alias(libs.plugins.kotlin.jvm) apply false
}

allprojects {
  group = "net.violetshine"
  version = "0.1.0-SNAPSHOT"
}

tasks.register<Exec>("dockerise") {
  description = "Runs Docker build to build a Docker image of the project."
  workingDir = projectDir
  commandLine = listOf("docker", "build", "-t", "violetshine-app:${version}", "--platform", "linux/amd64,linux/arm64", ".")
}
