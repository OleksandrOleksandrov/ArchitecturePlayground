package com.oleksandr.epic.repository.impl

import com.oleksandr.common.extension.withNullableListMapper
import com.oleksandr.database.source.datasource.EPICDbDataSource
import com.oleksandr.epic.mapper.EPICDbModelMapper
import com.oleksandr.epic.mapper.EPICDbRepoModelMapper
import com.oleksandr.epic.mapper.EPICRepoModelMapper
import com.oleksandr.epic.model.EPICNetModel
import com.oleksandr.epic.model.EPICRepoModel
import com.oleksandr.epic.repository.EPICRepository
import com.oleksandr.epic.source.EPICNetSource
import com.oleksandr.network.apiCall
import io.ktor.client.call.body
import kotlinx.coroutines.flow.Flow

class EPICRepositoryImpl(
    private val epicNetSource: EPICNetSource,
    private val dbSource: EPICDbDataSource,
) : EPICRepository {
    override val dataList: Flow<List<EPICRepoModel>?> =
        dbSource.getFlow().withNullableListMapper(EPICDbRepoModelMapper)

    private var tempCache: List<EPICRepoModel>? = mutableListOf()

    override suspend fun updateData() {
        dbSource.insert(
            EPICDbModelMapper.mapListFrom(
                epicNetSource.fetchEpic().body<List<EPICNetModel>>()
            )
        )
    }

    override suspend fun fetchData(): List<EPICRepoModel>? {
        apiCall {
            epicNetSource.fetchEpic()
        }.onSuccess { response ->
            tempCache = response.body<List<EPICNetModel>>().map(EPICRepoModelMapper::mapTo)
        }.onFailure {
            // Handle failure if needed
        }
         //TODO change temp solution
        return tempCache
    }


    override suspend fun getEpicById(id: String): EPICRepoModel? {
        tempCache?.find { it.identifier == id }?.let {
            return it
        }
        return null
    }

}