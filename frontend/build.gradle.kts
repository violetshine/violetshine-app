plugins {
  alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
  js {
    browser {
      webpackTask {
        mainOutputFileName = "app.js"
      }
    }

    useEsModules()
    binaries.executable()

    compilerOptions {
      target = "es2015"
    }
  }

  sourceSets {
    jsMain.dependencies {
      // implementation(npm("htmx.org", "2.0.8"))
      // implementation(kotlinWrappers.react)
      // implementation(kotlinWrappers.reactDom)
    }
  }
}
