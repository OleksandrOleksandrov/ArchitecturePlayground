package com.oleksandr.presentation.styling.theme

import androidx.compose.runtime.staticCompositionLocalOf
import com.oleksandr.presentation.styling.theme.core.ThemeCorner
import com.oleksandr.presentation.styling.theme.core.ThemeSpacing
import com.oleksandr.presentation.styling.theme.core.ThemeTypography

internal val LocalThemeColor =
    staticCompositionLocalOf<ThemeColor> {
        error("No implementation")
    }

internal val LocalThemeCorner =
    staticCompositionLocalOf<ThemeCorner> {
        error("No implementation")
    }

internal val LocalThemeSpacing =
    staticCompositionLocalOf<ThemeSpacing> {
        error("No implementation")
    }

internal val LocalThemeTypography =
    staticCompositionLocalOf<ThemeTypography> {
        error("No implementation")
    }
