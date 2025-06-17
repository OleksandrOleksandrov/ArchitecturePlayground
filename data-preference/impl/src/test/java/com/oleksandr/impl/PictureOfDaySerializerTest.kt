package com.oleksandr.impl

import com.google.common.truth.Truth.assertThat
import com.oleksandr.architectureplayground.data.preference.impl.model.PictureOfDayProtoModel
import com.oleksandr.impl.serializer.PictureOfDaySerializer
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream

class PictureOfDaySerializerTest {

    private val serializer = PictureOfDaySerializer()

    @Test
    fun `default value is correct`() {
        val defaultValue = serializer.defaultValue
        assertThat(defaultValue).isEqualTo(PictureOfDayProtoModel.getDefaultInstance())
    }

    @Test
    fun `readFrom returns correct model`() = runBlocking {
        val model = PictureOfDayProtoModel.newBuilder().setUrl("https://example.com").build()
        val outputStream = ByteArrayOutputStream()

        model.writeTo(outputStream)

        val result = serializer.readFrom(ByteArrayInputStream(outputStream.toByteArray()))
        assertThat(result).isEqualTo(model)
    }

    @Test
    fun `writeTo writes correct data`() = runBlocking {
        val model = PictureOfDayProtoModel.newBuilder().setUrl("https://example.com").build()
        val outputStream = ByteArrayOutputStream()

        serializer.writeTo(model, outputStream)
        val result =
            PictureOfDayProtoModel.parseFrom(ByteArrayInputStream(outputStream.toByteArray()))

        assertThat(result).isEqualTo(model)
    }
}