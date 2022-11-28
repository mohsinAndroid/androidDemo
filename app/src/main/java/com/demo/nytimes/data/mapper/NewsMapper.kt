package com.demo.nytimes.data.mapper

import com.demo.nytimes.data.model.*
import com.demo.nytimes.domain.model.NyNews

internal object NewsMapper {

    fun map(jsonNews: Results): NyNews {
        return NyNews(
            id = jsonNews.id,
            publishedDate = jsonNews.publishedDate.orEmpty(),
            updated = jsonNews.updated.orEmpty(),
            section = jsonNews.section.orEmpty(),
            uri = jsonNews.uri.orEmpty(),
            url = jsonNews.url.orEmpty(),
            type = jsonNews.type.orEmpty(),
            title = jsonNews.title.orEmpty(),
            abstract = jsonNews.abstract.orEmpty()
        )
    }
}