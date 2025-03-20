package com.oleksandr.impl.source

import android.util.Log
import androidx.datastore.core.DataStore
import com.oleksandr.architectureplayground.data.preference.impl.model.PictureOfDayProtoModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.firstOrNull
import java.io.IOException

class PictureOfDayPreferenceDao(
    private val preference: DataStore<PictureOfDayProtoModel>,
) {
    fun subscribeToData(): Flow<PictureOfDayProtoModel?> =
        preference.data.catch { exception ->
            if (exception is IOException) {
                Log.d("Error", exception.message.toString())
                emit(PictureOfDayProtoModel.getDefaultInstance())
            } else {
                throw exception
            }
        }

    suspend fun getData(): PictureOfDayProtoModel? = preference.data.firstOrNull()

    suspend fun updateData(value: PictureOfDayProtoModel?) {
        preference.updateData { preference ->
            if (value == null) {
                PictureOfDayProtoModel.getDefaultInstance()
            } else {
                preference
                    .toBuilder()
                    .setDate(value.date)
                    .setExplanation(value.explanation)
                    .setHdurl(value.hdurl)
                    .setMediaType(value.mediaType)
                    .setTitle(value.title)
                    .setUrl(value.url)
                    .build()
            }
        }
    }
}