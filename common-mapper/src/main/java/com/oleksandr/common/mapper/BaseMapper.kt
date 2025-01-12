package com.oleksandr.common.mapper

interface BaseMapper<In : Any, Out : Any> {
    fun mapTo(model: In): Out =
        throw NotImplementedError("${this::class.java} function mapTo function for class ${model::class.java} is not implemented")

    fun mapFrom(model: Out): In =
        throw NotImplementedError("${this::class.java} function mapFrom function for class ${model::class.java} is not implemented")

    fun mapListTo(model: List<In>): List<Out> = model.map { mapTo(it) }
    fun mapListFrom(model: List<Out>): List<In> = model.map { mapFrom(it) }
}