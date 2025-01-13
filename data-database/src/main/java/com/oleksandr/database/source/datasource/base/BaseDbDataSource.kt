package com.oleksandr.database.source.datasource.base

import com.oleksandr.database.model.base.BaseDbModel
import kotlinx.coroutines.flow.Flow

interface BaseDbDataSource<T : BaseDbModel> {

    suspend fun get(id: Long): T?

    suspend fun get(): List<T>?

    fun getFlow(): Flow<List<T>?>

    suspend fun insert(value: T): Long

    suspend fun insert(values: List<T>)

    suspend fun update(value: T)

    suspend fun update(values: List<T>)

    suspend fun delete(id: Long)

    suspend fun delete(ids: List<Long>)

    suspend fun deleteAll()
}