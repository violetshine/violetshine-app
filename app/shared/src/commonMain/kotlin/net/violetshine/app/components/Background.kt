package net.violetshine.app.components

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

@Composable
fun Background() {
  val linear = remember {
    Brush.linearGradient(
      listOf(
        Color(0xFF3a005b), // Top left corner
        Color(0xFF370493), // Bottom right corner
      ),
    )
  }

  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(linear)
  )
}
