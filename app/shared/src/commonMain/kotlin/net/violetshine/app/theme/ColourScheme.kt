package net.violetshine.app.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class ColourScheme(
  val primary: Color,
  val background: Color,
)

internal val LocalColourScheme = staticCompositionLocalOf {
  ColourScheme(
    primary = Color.Unspecified,
    background = Color.Unspecified,
  )
}
