package com.lecezar.mreadytechtest.reposNetworking

import com.lecezar.mreadytechtest.domains.GitReposListDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GitReposService {

    @GET("search/repositories?sort=stars&q=topic:android&per_page=20&order=desc&page=1")
    fun getAllAndroidRepos(@Query("page") pageNr: Int): Call<GitReposListDto>

}