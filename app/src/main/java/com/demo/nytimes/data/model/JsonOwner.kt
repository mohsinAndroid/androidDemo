package com.demo.nytimes.data.model

import com.squareup.moshi.Json

data class JsonOwner(
    @field:Json(name = "avatar_url") val avatarUrl: String? = null
)