package net.violetshine.app.template.component.curve

import io.ktor.server.html.*
import kotlinx.html.*

import net.violetshine.app.template.tag.svg.*
  
enum class CurvePosition(val cssClasses: String) {
  TOP_LEFT("top-0 left-0"),
  TOP_RIGHT("top-0 right-0 rotate-90"),
  BOTTOM_LEFT("top-full left-0"),
  BOTTOM_RIGHT("top-full right-0 rotate-90"),
}

// 24 px rounding
fun DIV.curve(position: CurvePosition, fillColour: String, block: DIV.() -> Unit) {
  svg("absolute pointer-events-none w-[24px] h-[24px] fill-none ${position.cssClasses}") {
    attributes["viewBox"] = "0 0 24 24"
    g {
      attributes["clip-path"] = "url(#clipPath)"
      path {
        attributes["d"] = "M0 23V3.97324e-05H16.5H23.6618C23.6619 2.64878e-05 23.662 1.32437e-05 23.6621 0L24.75 3.97324e-05H23.6618C12.2531 1.39125 1.27929 7.85935 0 23Z"
        attributes["fill"] = fillColour
      }
    }
    defs {
      clipPath {
        attributes["id"] = "clipPath"
        rect {
          attributes["width"] = "24"
          attributes["height"] = "24"
          attributes["fill"] = "transparent"
        }
      }
    }
  }
}
