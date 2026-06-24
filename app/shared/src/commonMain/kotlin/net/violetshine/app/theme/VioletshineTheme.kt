package net.violetshine.app.theme

import androidx.compose.material3.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.Font

import violetshineapp.app.shared.generated.resources.Res as R
import violetshineapp.app.shared.generated.resources.DarkmodeOn_Regular
import violetshineapp.app.shared.generated.resources.DarkmodeOn_Bold

/**
 * The custom theme of the app.
 *
 * See https://developer.android.com/develop/ui/compose/designsystems/custom#implementing-fully-custom
 */
@Composable
fun VioletshineTheme(
  content: @Composable () -> Unit,
) {
  val darkModeColours = ColourScheme(
    primary = Color(0x7700f0),
    background = Color.DarkGray,
  )

  val darkmodeFamily = FontFamily(
    Font(R.font.DarkmodeOn_Regular, FontWeight.Normal),
    Font(R.font.DarkmodeOn_Bold, FontWeight.Bold),
  )

  val typography = Typography(
    body = TextStyle(
      fontFamily = darkmodeFamily,
      fontSize = 12.sp,
      fontWeight = FontWeight.Normal,
    ),
    title = TextStyle(
      fontFamily = darkmodeFamily,
      fontSize = 24.sp,
      fontWeight = FontWeight.Bold,
    ),
  )

  CompositionLocalProvider(
    LocalColourScheme provides darkModeColours,
    LocalTypography provides typography,
  ) {
    ProvideTextStyle(typography.body, content)
  }
}

object VioletshineTheme {
  val colourScheme: ColourScheme
    @Composable @ReadOnlyComposable get() = LocalColourScheme.current

  val typography: Typography
    @Composable @ReadOnlyComposable get() = LocalTypography.current
}
