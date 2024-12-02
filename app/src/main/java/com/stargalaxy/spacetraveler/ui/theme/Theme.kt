package com.stargalaxy.spacetraveler.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

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

// Можем использовать значения кастомной темы через обращение к полям JetSpaceTravelerTheme,
// обернув предварительно класс в SpaceTravelerTheme.
object JetSpaceTravelerTheme{
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
    content: @Composable () -> Unit
) {
// Мы убираем динамические цвета, потому что у них выше приоритет, чем у кастомной темы
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

// При вызове CompositionLocalProvider объекту ProvidableCompositionLocal передается
// некоторое значение с помощью слова provides
    CompositionLocalProvider(
        LocalSpaceTravelerColors provides colorScheme,
        LocalSpaceTravelerTypography provides typography,
        LocalSpaceTravelerShape provides shapes,
        content = content
    )
}