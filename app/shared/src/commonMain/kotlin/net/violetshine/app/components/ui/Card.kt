package net.violetshine.app.components.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp

import net.violetshine.app.theme.VioletshineTheme

@Composable
fun Card(
  modifier: Modifier = Modifier,
  content: @Composable (BoxScope.() -> Unit),
) {
  Box(
    modifier = modifier
      .dropShadow(
        shape = RoundedCornerShape(16.dp),
        shadow = Shadow(
          radius = 10.dp,
          spread = 6.dp,
          color = Color(0x40000000),
          offset = DpOffset(x = 4.dp, 4.dp)
        ),
      )
      .background(
        color = VioletshineTheme.colourScheme.background,
        shape = RoundedCornerShape(20.dp)
      )
      .padding(10.dp),
    content = content,
  )
}
