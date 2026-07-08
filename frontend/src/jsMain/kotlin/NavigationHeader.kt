package net.violetshine.app.frontend

import kotlinx.browser.document

import net.violetshine.app.frontend.state.ScrollData
import net.violetshine.app.frontend.state.ScrollDirection

enum class NavigationScrollState(val cssClasses: String) {
  SCROLL_UP("sticky top-0 left-0 transform-[translateY(0)] animate-header-slide-down"),
  SCROLL_DOWN("sticky top-0 left-0 transform-[translateY(-120%)]"),
  FROM_SCROLL_UP("animate-header-slide-up"),
}

class NavigationHeader {
  private val element = document.getElementById("navigation")
    ?: throw Exception("Cannot find navigation header element!")

  private val baseClasses = element.className

  private var scrollUp = false
  private var scrollDown = false
  private var fromScrollUp = false

  fun onScroll(newScrollData: ScrollData) {
    val body = document.body ?: return

    if (newScrollData.scrollY > element.getBoundingClientRect().height) {
      if (newScrollData.direction == ScrollDirection.UP) {
        scrollUp = true
        scrollDown = false
        fromScrollUp = false
      } else {
        if (scrollUp) {
          fromScrollUp = true
        }

        scrollDown = true
        scrollUp = false
      }
    }

    var newClassName = baseClasses
    if (scrollUp) {
      newClassName += " ${NavigationScrollState.SCROLL_UP.cssClasses}"
    }
    if (scrollDown) {
      newClassName += " ${NavigationScrollState.SCROLL_DOWN.cssClasses}"
    }
    if (fromScrollUp) {
      newClassName += " ${NavigationScrollState.FROM_SCROLL_UP.cssClasses}"
    }

    element.className = newClassName
  }
}
