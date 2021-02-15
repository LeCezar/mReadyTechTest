package com.lecezar.mreadytechtest.utils.helpers

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

inline fun <T> Call<T>.executeRequest(crossinline onSuccess: (T) -> Unit, crossinline onError: () -> Unit) {
    enqueue(object : Callback<T> {

        override fun onResponse(call: Call<T>?, response: Response<T>?) {
            val body = response?.body()
            if (body == null || !response.isSuccessful) {
                onError()
            } else {
                onSuccess(body)
            }
        }

        override fun onFailure(call: Call<T>?, t: Throwable?) = onError()
    })
}