package net.violetshine.app.template.navigation

import io.ktor.server.html.*
import kotlinx.html.*

class NavigationHeader : Template<FlowContent> {
  override fun FlowContent.apply() {
    header("bg-transparent relative z-50") {
      // Secondary navigation
      div("flex flex-row justify-between pl-6 pr-6 pt-4 pb-4 bg-dark-violet") {
        // Alert
        div("w-full") { 
          
        }
        // Secondary nav links
        nav {
          ul("flex flex-row justify-end gap-10 list-none m-0 p-0") {
            li {
              a("/contact") {
                +"Contact"
              }
            }
          }
        }
      }

      // Main navigation
      div("pl-6 pr-6") {
        a {
          
        }
        nav {
          
        }
      }
    }
  }
}
