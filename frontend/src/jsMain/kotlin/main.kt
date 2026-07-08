package net.violetshine.app.frontend

import net.violetshine.app.frontend.state.ScrollState

fun main() {
  val scrollState = ScrollState()
  val navigationHeader = NavigationHeader()

  scrollState.addObserver("navigation", navigationHeader::onScroll)
}
