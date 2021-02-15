package com.lecezar.mreadytechtest.reposNetworking

import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.lang.reflect.Type

class NetworkManager {
    private val retrofit: Retrofit
    private val retrofitReadMe: Retrofit
    private val BASE_URL = "https://api.github.com/"
    private val BASE_URL_README = "https://raw.githubusercontent.com/"

    init {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
            .build()
        retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(object : Converter.Factory() {
                override fun responseBodyConverter(
                    type: Type,
                    annotations: Array<out Annotation>,
                    retrofit: Retrofit
                ): Converter<ResponseBody, *>? =
                    if (type == Unit::class.java) UnitConverter else null
            })
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        retrofitReadMe = Retrofit.Builder().baseUrl(BASE_URL_README)
            .client(okHttpClient)
            .addConverterFactory(object : Converter.Factory() {
                override fun responseBodyConverter(
                    type: Type,
                    annotations: Array<out Annotation>,
                    retrofit: Retrofit
                ): Converter<ResponseBody, *>? =
                    if (type == Unit::class.java) UnitConverter else null
            })
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()

    }

    val gitReposService: GitReposService = retrofit.create(GitReposService::class.java)
    val gitReposReadMe: GitReposReadMeService = retrofitReadMe.create(GitReposReadMeService::class.java)

    private object UnitConverter : Converter<ResponseBody, Unit> {
        override fun convert(value: ResponseBody) {
            value.close()
        }
    }
}

