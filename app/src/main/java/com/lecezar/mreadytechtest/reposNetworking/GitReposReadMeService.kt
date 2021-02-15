package com.lecezar.mreadytechtest.reposNetworking

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Streaming

interface GitReposReadMeService {

    @GET("{owner}/{repo}/master/README.md")
    fun getReadMe(@Path("owner") owner: String, @Path("repo") repo: String): Call<String>

}