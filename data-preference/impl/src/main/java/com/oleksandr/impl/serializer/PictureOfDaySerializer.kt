package com.oleksandr.impl.serializer

import androidx.datastore.core.Serializer
import com.google.protobuf.InvalidProtocolBufferException
import com.oleksandr.architectureplayground.data.preference.impl.model.PictureOfDayProtoModel
import java.io.InputStream
import java.io.OutputStream

class PictureOfDaySerializer : Serializer<PictureOfDayProtoModel> {
    override val defaultValue: PictureOfDayProtoModel = PictureOfDayProtoModel.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): PictureOfDayProtoModel {
        try {
            return PictureOfDayProtoModel.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw Exception("Cannot read proto.", exception)
        }
    }

    override suspend fun writeTo(t: PictureOfDayProtoModel, output: OutputStream) = t.writeTo(output)
}