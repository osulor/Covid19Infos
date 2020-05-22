package com.example.covid19infos.util

sealed class ApiCallState <T> (val data: T? = null, val message: String? = null) {

    class Success<T>(data: T) : ApiCallState<T>(data)
    class Error<T>(message: String?, data: T? = null) : ApiCallState<T>(data,message)
    class Loading<T> : ApiCallState<T>()

}