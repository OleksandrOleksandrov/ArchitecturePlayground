package com.oleksandr.database.impl.source

import com.oleksandr.database.impl.source.dao.EPICDao
import com.oleksandr.database.model.EPICDbModel
import com.oleksandr.database.source.datasource.EPICDbDataSource
import kotlinx.coroutines.flow.Flow

class EPICDbDataSourceImpl(
    private val dao: EPICDao,
) : EPICDbDataSource {
    override suspend fun get(id: Long): EPICDbModel? = dao.get(id)

    override suspend fun get(): List<EPICDbModel>? = dao.get()

    override fun getFlow(): Flow<List<EPICDbModel>?> = dao.subscribe()

    override suspend fun insert(value: EPICDbModel): Long = dao.insert(value)

    override suspend fun insert(values: List<EPICDbModel>) {
        values.forEach {
            dao.insert(it)
        }
    }

    override suspend fun update(value: EPICDbModel) = dao.update(value)

    override suspend fun update(values: List<EPICDbModel>) {
        values.forEach {
            dao.update(it)
        }
    }

    override suspend fun delete(id: Long) = dao.delete(id)

    override suspend fun delete(ids: List<Long>) {
        ids.forEach {
            dao.delete(it)
        }
    }

    override suspend fun deleteAll() = dao.deleteAll()
}