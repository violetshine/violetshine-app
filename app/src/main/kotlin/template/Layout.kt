package net.violetshine.app.template

import io.ktor.server.html.*
import kotlinx.html.*
  
import net.violetshine.app.template.navigation.NavigationHeader

class Layout : Template<HTML> {
  val pageTitle = Placeholder<TITLE>()
  
  val navigation = TemplatePlaceholder<NavigationHeader>()

  override fun HTML.apply() {
    head {
      title {
        insert(pageTitle)
        +" | Violetshine"
      }

      link(rel = "stylesheet", href = "/_/css/styles.css")
      script(src = "/_/js/app.js", type = "module") {  }
    }
    
    body(classes = "font-[\"Inter\", sans-serif] bg-dark-violet text-white") {
      insert(NavigationHeader(), navigation)
    }
  }
}
