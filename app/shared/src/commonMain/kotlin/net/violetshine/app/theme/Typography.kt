package net.violetshine.app.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle

@Immutable
data class Typography(
  val body: TextStyle,
  val title: TextStyle,
)

internal val LocalTypography = staticCompositionLocalOf {
  Typography(
    body = TextStyle.Default,
    title = TextStyle.Default,
  )
}
