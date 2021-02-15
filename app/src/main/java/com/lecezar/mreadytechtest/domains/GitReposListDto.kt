package com.lecezar.mreadytechtest.domains

import com.squareup.moshi.Json

data class GitReposListDto(
    @field:Json(name = "total_count")
    val resultNo: Int,
    @field:Json(name = "items")
    val reposList: List<GitRepoDto>
)