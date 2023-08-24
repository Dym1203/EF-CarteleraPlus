package com.ef.dylan.carteleraplus.data

sealed class MovieServiceResult<T> (data : T? = null, error : Exception? = null) {
    data class Success<T>(val data : T) : MovieServiceResult<T>(data, null)
    data class Error<T>(val error : Exception) : MovieServiceResult<T>(null, error)
}