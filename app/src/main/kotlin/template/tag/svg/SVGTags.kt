package net.violetshine.app.template.tag.svg

import io.ktor.server.html.*
import kotlinx.html.*

// kotlinx.html doesn't appear to have some SVG tags so we have to manually add them ourselves
class G(consumer: TagConsumer<*>) : 
  HTMLTag("g", consumer, emptyMap(), inlineTag = true, emptyTag = false),
    HtmlInlineTag

fun SVG.g(block: G.() -> Unit = {}) {
  G(consumer).visit(block)
}

class PATH(consumer: TagConsumer<*>) : 
  HTMLTag("path", consumer, emptyMap(), inlineTag = true, emptyTag = false),
    HtmlInlineTag

fun G.path(block: PATH.() -> Unit = {}) {
  PATH(consumer).visit(block)
}

fun SVG.path(block: PATH.() -> Unit = {}) {
  PATH(consumer).visit(block)
}

class DEFS(consumer: TagConsumer<*>) : 
  HTMLTag("defs", consumer, emptyMap(), inlineTag = true, emptyTag = false),
    HtmlInlineTag
    
fun SVG.defs(block: DEFS.() -> Unit = {}) {
  DEFS(consumer).visit(block)
}

class CLIPPATH(consumer: TagConsumer<*>) : 
  HTMLTag("clipPath", consumer, emptyMap(), inlineTag = true, emptyTag = false),
    HtmlInlineTag

fun DEFS.clipPath(block: CLIPPATH.() -> Unit = {}) {
  CLIPPATH(consumer).visit(block)
}

class RECT(consumer: TagConsumer<*>) : 
  HTMLTag("rect", consumer, emptyMap(), inlineTag = true, emptyTag = false),
    HtmlInlineTag

fun CLIPPATH.rect(block: RECT.() -> Unit = {}) {
  RECT(consumer).visit(block)
}

fun SVG.rect(block: RECT.() -> Unit = {}) {
  RECT(consumer).visit(block)
}
