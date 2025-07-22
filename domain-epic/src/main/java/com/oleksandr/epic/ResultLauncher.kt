package com.oleksandr.epic

typealias Optional = Result<Unit>

suspend fun <T> resultLauncher(action: suspend () -> T): Result<T> = try {
    Result.success(action())
} catch (e: Exception) {
    Result.failure(e)//TODO later
}

