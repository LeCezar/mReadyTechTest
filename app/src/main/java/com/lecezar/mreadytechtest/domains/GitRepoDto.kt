package com.lecezar.mreadytechtest.domains

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class GitRepoDto(
    @field: Json(name = "id")
    val id: Long,
    @field: Json(name = "name")
    val name: String,
    @field:Json(name = "full_name")
    val fullName: String,
    @field:Json(name = "owner")
    val owner: GitRepoOwnerDto,
    @field:Json(name = "stargazers_count")
    val stargazersCount: Int,
    @field:Json(name = "watchers_count")
    val watchersCount: Int,
    @field:Json(name = "language")
    val language: String,
    @field:Json(name = "forks_count")
    val forksCount: Int,
    @field:Json(name = "open_issues_count")
    val openIssuesCount: Int
) : Parcelable