package com.oleksandr.common.core

import com.oleksandr.common.exception.AppException

sealed class Resource<out T> {
    data class Success<T>(val data: T) : Resource<T>()
    data class Failure(val error: AppException) : Resource<Nothing>()

    inline fun onSuccess(onSuccess: (T) -> Unit): Resource<T> {
        if (this is Success) {
            onSuccess(this.data)
        }
        return this
    }

    inline fun onFailure(onFailure: (Failure) -> Unit): Resource<T> {
        if (this is Failure) {
            onFailure(this)
        }
        return this
    }

    inline fun <R> map(
        transformFailure: (Failure) -> Resource<R> = { it },
        transformSuccess: (Success<out T>) -> Resource<R>
    ): Resource<R> {
        return when (this) {
            is Success -> transformSuccess(this)
            is Failure -> transformFailure(this)
        }
    }

    inline fun <R> mapSuccess(transform: (T) -> R): Resource<R> {
        return when(this) {
            is Success -> Success(transform(this.data))
            is Failure -> this
        }
    }

    fun <R> combine(other: Resource<R>): Resource<Pair<T, R>> {
        return when {
            this is Failure -> this
            other is Failure -> other
            else -> {
                this as Success<T>
                other as Success<R>
                Success(this.data to other.data)
            }
        }
    }

    fun mapUnit(): Resource<Unit> {
        return when (this) {
            is Success -> Success(Unit)
            is Failure -> this
        }
    }

    fun getOrNull(): T? = (this as? Success)?.data

    fun errorOrNull(): AppException? = (this as? Failure)?.error
}