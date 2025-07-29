package com.oleksandr.epic.details.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class EpicDetailsDirections {
    @Serializable
    data class EpicDetails(
        val identifier: String? = null,
    ) : EpicDetailsDirections()
}
