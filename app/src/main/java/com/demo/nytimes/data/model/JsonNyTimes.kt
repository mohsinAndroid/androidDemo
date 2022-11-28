package com.demo.nytimes.data.model

import com.squareup.moshi.Json

data class JsonNyTimes(
    @field:Json(name = "status") var status: String? = null,
    @field:Json(name = "copyright") var copyright: String? = null,
    @field:Json(name = "num_results") var numResults: Int? = null,
    @field:Json(name = "results") var results: List<Results> = arrayListOf()


)