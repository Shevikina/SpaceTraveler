package com.stargalaxy.spacetraveler.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    background = BackgroundColor,
    primary = PrimaryColor,
    secondary = SecondaryColor,
    surface = SurfaceColor,
    tertiary = Pink80,
    onPrimary = OnPrimaryColor,
    onSecondary = OnSecondaryColor,
    onBackground = OnBackgroundColor,
    onSurface = OnSurfaceColor
)

private val LightColorScheme = lightColorScheme(
    background = BackgroundColor,
    primary = PrimaryColor,
    secondary = SecondaryColor,
    surface = SurfaceColor,
    tertiary = Pink40,
    onPrimary = OnPrimaryColor,
    onSecondary = OnSecondaryColor,
    onBackground = OnBackgroundColor,
    onSurface = OnSurfaceColor
)

// CompositionLocal позволяет объявлять состояние на самом высоком уровне,
// а затем получать к нему доступ на любых нижних уровнях
// без необходимости передавать состояние через промежуточные дочерние элементы.

val LocalSpaceTravelerColors = staticCompositionLocalOf<ColorScheme> {
    error("No colors provided")
}

val LocalSpaceTravelerTypography = staticCompositionLocalOf<Typography> {
    error("No font provided")
}

val LocalSpaceTravelerShape = staticCompositionLocalOf<JetSpaceTravelerShapes> {
    error("No shapes provided")
}


object SpaceTravelerTheme{
    val colorScheme: ColorScheme
        @Composable
        get() = LocalSpaceTravelerColors.current

    val typography: Typography
        @Composable
        get() = LocalSpaceTravelerTypography.current

    val shapes: JetSpaceTravelerShapes
        @Composable
        get() = LocalSpaceTravelerShape.current
}

@Composable
fun SpaceTravelerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

// При вызове CompositionLocalProvider объекту ProvidableCompositionLocal передается некоторое
// значение с помощью слова provides
    CompositionLocalProvider(
        LocalSpaceTravelerColors provides colorScheme,
        LocalSpaceTravelerTypography provides typography,
        LocalSpaceTravelerShape provides shapes,
        content = content
    )
}