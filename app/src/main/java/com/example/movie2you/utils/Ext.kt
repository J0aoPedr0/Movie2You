package com.example.movie2you.utils

import android.util.Log
import kotlinx.coroutines.flow.Flow

suspend fun <T> Flow<Response<T>>.collectAndHandle(
    onError: (Throwable?) -> Unit = {
        Log.e("collectAndHandle", "collectAndHandle: error", it)
    },
    onLoading: () -> Unit = {},
    stateReducer: (T) -> Unit,
) {
    collect { response ->
        when (response) {
            is Response.Failure -> {
                onError(response.failure)
            }

            is Response.Success -> {
                stateReducer(response.data)
            }

            is Response.Loading -> {
                onLoading()
            }
        }
    }
}