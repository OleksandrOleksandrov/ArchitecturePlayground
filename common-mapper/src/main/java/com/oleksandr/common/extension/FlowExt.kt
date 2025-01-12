package com.oleksandr.common.extension

import com.oleksandr.common.mapper.BaseMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

inline fun <reified In : Any, reified Out : Any> Flow<In?>.withMapper(mapper: BaseMapper<In, Out>): Flow<Out?> =
    mapNonNullValue(mapper::mapTo)

inline fun <reified In : Any, reified Out : Any> Flow<Out?>.withReverseMapper(mapper: BaseMapper<In, Out>): Flow<In?> =
    mapNonNullValue(mapper::mapFrom)

inline fun <reified In : Any, reified Out : Any> Flow<List<In>>.withListMapper(
    mapper: BaseMapper<In, Out>,
): Flow<List<Out>> = map(mapper::mapListTo)

inline fun <reified In : Any, reified Out : Any> Flow<List<Out>>.withReverseListMapper(
    mapper: BaseMapper<In, Out>,
): Flow<List<In>> = map(mapper::mapListFrom)

inline fun <T, R> Flow<T?>.mapNonNullValue(crossinline predicate: (T) -> R): Flow<R?> =
    map { it?.run(predicate) }