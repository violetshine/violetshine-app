package net.violetshine.app.template

import io.ktor.server.html.*
import kotlinx.html.*

import net.violetshine.app.template.navigation.NavigationHeader
import net.violetshine.app.template.component.background.WaveBackground

class Layout : Template<HTML> {
  val pageTitle = Placeholder<TITLE>()
  
  val navigation = TemplatePlaceholder<NavigationHeader>()
  
  private val footerWaveBackground = TemplatePlaceholder<WaveBackground>()

  override fun HTML.apply() {
    head {
      title {
        insert(pageTitle)
        +" | Violetshine"
      }

      link(rel = "stylesheet", href = "/_/css/styles.css")
      script(src = "/_/js/app.js", type = "module") {  }
    }
    
    body(classes = "font-[\"Inter\", sans-serif] bg-surface text-text") {
      insert(NavigationHeader(), navigation)
      
      main {  }
      
      footer("w-full") {
        attributes["role"] = "contentinfo"
        insert(WaveBackground(), footerWaveBackground)
      }
    }
  }
}
