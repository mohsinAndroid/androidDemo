package com.demo.nytimes.domain.model

import java.io.Serializable

data class NyNews(
    val id: Double?,
    val publishedDate: String? = "",
    val updated: String? = "",
    val section: String? = "",
    val uri: String? = "",
    val url: String? = "",
    val type: String? = "",
    val title: String? = "",
    val abstract: String? = "",
): Serializable