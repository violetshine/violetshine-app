package net.violetshine.app.components.ui

import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text as Material3Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle

import net.violetshine.app.theme.VioletshineTheme

@Composable
fun Text(
  text: String,
  style: TextStyle = VioletshineTheme.typography.body,
  modifier: Modifier = Modifier,
) {
  ProvideTextStyle(style + TextStyle(color = VioletshineTheme.colourScheme.onBackground)) {
    Material3Text(text, modifier)
  }
}

@Composable
fun SelectableText(
  text: String,
  style: TextStyle = VioletshineTheme.typography.body,
  modifier: Modifier = Modifier,
) {
  SelectionContainer {
    Text(text, style, modifier)
  }
}
