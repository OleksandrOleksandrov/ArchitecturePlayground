package com.oleksandr.apod.repository

import com.oleksandr.apod.model.APODRepoModel
import kotlinx.coroutines.flow.Flow

interface APODRepository {
    val data: Flow<APODRepoModel?>

    suspend fun updateData()
}