package com.droidDevOs.verifyswift.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

/**
 * Light default theme color scheme
 */
val LightColorScheme = lightColorScheme(
    primary = Blue003,
    onPrimary = Color.White,
    secondary = PurpleGrey40,
    tertiary = Pink40,
    onSecondary = Color.White,
    onTertiary = Color.White,
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
)


/**
 * Dark default theme color scheme
 */
val DarkColorScheme = darkColorScheme(
    primary = Blue003,
    secondary = BlueC2,
    tertiary = BlueF2
)


@Composable
fun DevOsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    androidTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    // Color scheme
    val colorScheme = when {
        androidTheme && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }



    MaterialTheme(
        colorScheme = colorScheme,
        content = content,
    )

}