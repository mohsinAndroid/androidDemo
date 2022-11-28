package com.demo.nytimes.data.model

import com.squareup.moshi.Json

data class Results(
    @field:Json(name = "id") val id: Double? = null,
    @field:Json(name = "uri") val uri: String? = null,
    @field:Json(name = "url") val url: String? = null,
    @field:Json(name = "asset_id") val assetId: Double? = null,
    @field:Json(name = "source") val source: String? = null,
    @field:Json(name = "published_date") val publishedDate: String? = null,
    @field:Json(name = "updated") val updated: String? = null,
    @field:Json(name = "section") val section: String? = null,
    @field:Json(name = "subsection") val subsection: String? = null,
    @field:Json(name = "nytdsection") val nytdsection: String? = null,
    @field:Json(name = "adx_keywords") val adxKeywords: String? = null,
    @field:Json(name = "column") val column: String? = null,
    @field:Json(name = "byline") val byline: String? = null,
    @field:Json(name = "type") val type: String? = null,
    @field:Json(name = "title") val title: String? = null,
    @field:Json(name = "abstract") val abstract: String? = null

)