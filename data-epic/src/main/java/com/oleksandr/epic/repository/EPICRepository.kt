package com.oleksandr.epic.repository

import com.oleksandr.epic.model.EPICRepoModel
import kotlinx.coroutines.flow.Flow

interface EPICRepository {
    val dataList: Flow<List<EPICRepoModel>?>

    suspend fun updateData()
}