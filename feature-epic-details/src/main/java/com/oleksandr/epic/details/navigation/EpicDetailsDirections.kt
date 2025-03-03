package com.oleksandr.epic.details.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class EpicDetailsDirections {
    @Serializable
    data class EpicDetails(
        val identifier: String? = null,
        val caption: String? = null,
        val image: String? = null,
        val date: String? = null,
    ) : EpicDetailsDirections()
}
