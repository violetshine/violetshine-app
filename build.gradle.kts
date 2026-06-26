plugins {
  alias(libs.plugins.kotlin.multiplatform) apply false
  alias(libs.plugins.kotlin.jvm) apply false
}

subprojects {
  group = "net.violetshine"
  version = "0.1.0-SNAPSHOT"
}
