package com.oleksandr.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class BaseNavigationDirection {

    @Serializable
    data object Main : BaseNavigationDirection()

    /**
     * Earth Polychromatic Imaging Camera (EPIC)
     */
    @Serializable
    data object EPIC : BaseNavigationDirection()
}
