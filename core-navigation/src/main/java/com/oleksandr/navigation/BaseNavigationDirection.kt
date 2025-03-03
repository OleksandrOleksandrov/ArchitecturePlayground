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

    /**
     * Earth Polychromatic Imaging Camera (EPIC) Details
     */
    @Serializable
    data class EpicDetails(
        val identifier: String? = null,
        val caption: String? = null,
        val image: String? = null,
        val date: String? = null,
    ) : BaseNavigationDirection()
}
