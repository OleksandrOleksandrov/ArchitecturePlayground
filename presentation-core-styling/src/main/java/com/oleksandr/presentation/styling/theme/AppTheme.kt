package com.oleksandr.presentation.styling.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.oleksandr.presentation.styling.theme.attribute.attributeCorner
import com.oleksandr.presentation.styling.theme.attribute.attributeSpacing
import com.oleksandr.presentation.styling.theme.attribute.color.attributeDarkColorPalette
import com.oleksandr.presentation.styling.theme.attribute.color.attributeLightColorPalette

/**
 * A composable function that provides a custom theme for the app, based on the selected theme mode (light or dark).
 *
 * This function sets up various theme attributes such as colors, typography, corner radius, font sizes, icon sizes,
 * line heights, and spacing. The theme is applied using [CompositionLocalProvider], making these attributes available
 * to any composable functions within the [content] block.
 *
 * The theme can be switched between light and dark modes by changing the [useDarkTheme] parameter.
 *
 * @param useDarkTheme A flag that determines whether to use the dark theme or the light theme.
 *                     By default, it is `false` (light theme).
 * @param content The composable content that will be rendered with the applied theme. This allows the theme
 *                to be applied globally to any child composable.
 */
@Composable
fun AppTheme(
    useDarkTheme: Boolean = false,
    content: @Composable () -> Unit,
) {

    val currentColorPalette = when {
        useDarkTheme -> attributeDarkColorPalette
        else -> attributeLightColorPalette
    }

    CompositionLocalProvider(
        LocalThemeColor provides currentColorPalette,
        LocalThemeCorner provides attributeCorner,
        LocalThemeSpacing provides attributeSpacing,
        LocalThemeTypography provides attributeTypography,
        content = content,
    )
}
