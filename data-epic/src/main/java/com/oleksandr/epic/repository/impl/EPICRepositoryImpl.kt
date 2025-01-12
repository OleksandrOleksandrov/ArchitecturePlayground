package com.oleksandr.epic.repository.impl

import com.oleksandr.epic.mapper.EPICModelMapper
import com.oleksandr.epic.model.EPICNetModel
import com.oleksandr.epic.model.EPICRepoModel
import com.oleksandr.epic.repository.EPICRepository
import com.oleksandr.epic.source.EPICNetSource
import io.ktor.client.call.body
import kotlinx.coroutines.flow.MutableStateFlow

class EPICRepositoryImpl(
    private val epicNetSource: EPICNetSource,
    private val epicModelMapper: EPICModelMapper,
) : EPICRepository {
    override val dataList: MutableStateFlow<List<EPICRepoModel>> = MutableStateFlow(emptyList())

    override suspend fun updateData() {
        dataList.value = epicModelMapper.mapListTo(epicNetSource.fetchEpic().body<List<EPICNetModel>>())
    }
}