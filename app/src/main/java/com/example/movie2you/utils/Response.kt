package com.example.movie2you.utils

sealed class Response<T> {
    class Success<T>(val data: T) : Response<T>()
    class Failure<T>(val failure:Throwable?, val data: T? = null) : Response<T>()
    class Loading<T> : Response<T>()

}