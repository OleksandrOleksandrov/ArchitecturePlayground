package com.oleksandr.epic.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class EpicDirections {
    @Serializable
    data object Epic: EpicDirections()
}
