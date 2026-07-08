package net.violetshine.app.frontend.state

import kotlinx.browser.document
import org.w3c.dom.events.Event

enum class ScrollDirection { UP, DOWN }

data class ScrollData(
  val scrollX: Double,
  val scrollY: Double,
  val direction: ScrollDirection?,
  val percentage: Double,
)

class ScrollState : State<ScrollData>() {
  override var value = ScrollData(0.0, 0.0, null, 0.0)
  private var lastScrollTop = 0.0

  private fun onScroll(ev: Event) {
    val body = document.body ?: return
    val documentElement = document.documentElement ?: return

    val bodyOffset = body.getBoundingClientRect()

    val newScrollY = -bodyOffset.top
    val newScrollX = bodyOffset.left
    val newScrollDirection = if (lastScrollTop > -bodyOffset.top) ScrollDirection.UP else ScrollDirection.DOWN

    lastScrollTop = -bodyOffset.top

    val windowScroll = body.scrollTop
    val height = documentElement.scrollHeight - documentElement.clientHeight
    val scrollPercentage = try { windowScroll / height } catch(_: Throwable) { null }

    if (scrollPercentage != null) {
      setValue(ScrollData(newScrollX, newScrollY, newScrollDirection, scrollPercentage))
    } else {
      setValue(ScrollData(newScrollX, newScrollY, newScrollDirection, value.percentage))
    }
  }

  init {
    document.addEventListener("scroll", ::onScroll)
  }
}
