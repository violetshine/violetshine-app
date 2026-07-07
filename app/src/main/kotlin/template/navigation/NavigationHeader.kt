package net.violetshine.app.template.navigation

import io.ktor.server.html.*
import kotlinx.html.*
  
import net.violetshine.app.template.component.curve.*

class NavigationHeader : Template<FlowContent> {
  override fun FlowContent.apply() {
    header("bg-transparent relative z-50") {
      // Secondary navigation
      div("flex flex-row justify-between pl-6 pr-6 pt-4 pb-4 bg-surface") {
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
      div("relative w-full min-h-[88px] bg-surface-2 pl-6 pr-6") {
        a {
          
        }
        nav {
          
        }
        curve(CurvePosition.BOTTOM_LEFT, "var(--color-surface-2)") {}
        curve(CurvePosition.BOTTOM_RIGHT, "var(--color-surface-2)") {}
        curve(CurvePosition.TOP_LEFT, "var(--color-surface-2)") {}
        curve(CurvePosition.TOP_RIGHT, "var(--color-surface-2)") {}
      }
    }
  }
}
