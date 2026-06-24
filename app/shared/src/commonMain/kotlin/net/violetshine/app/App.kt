package net.violetshine.app

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfoV2
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.window.core.layout.WindowSizeClass

import net.violetshine.app.theme.VioletshineTheme
import net.violetshine.app.components.Background
import net.violetshine.app.components.ui.Card
import net.violetshine.app.components.ui.Text
import net.violetshine.app.components.ui.SelectableText

@Composable
@Preview
fun App(windowSizeClass: WindowSizeClass = currentWindowAdaptiveInfoV2().windowSizeClass) {
  val desktopWidth = windowSizeClass.isWidthAtLeastBreakpoint(WindowSizeClass.WIDTH_DP_MEDIUM_LOWER_BOUND)

  VioletshineTheme {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
      Background()
      Column(
        modifier = if (desktopWidth) {
          Modifier.width(580.dp)
        } else {
          Modifier.fillMaxWidth()
        }
      ) {
        Spacer(modifier = Modifier.height(12.dp).fillMaxWidth())
        Card(modifier = Modifier.fillMaxWidth()) {
          Column(modifier = Modifier.fillMaxWidth()) {
            Text("Violetshine", style = VioletshineTheme.typography.title)
            Spacer(modifier = Modifier.height(10.dp).fillMaxWidth())
            SelectableText(
              "G'day! I'm Violet and this is my personal website that I'm currently building. " +
                "There isn't anything interesting here quite yet as I still need to decide what " +
                "I want to have here."
            )
          }
        }
      }
    }
  }
}
