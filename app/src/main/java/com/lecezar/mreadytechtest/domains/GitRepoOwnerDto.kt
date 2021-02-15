package com.lecezar.mreadytechtest.domains

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class GitRepoOwnerDto(
    @field:Json(name = "id")
    val id: Long,
    @field:Json(name = "login")
    val userName: String,
    @field:Json(name = "type")
    val type: String
): Parcelable
