package com.demo.nytimes.data.mapper

import com.demo.nytimes.data.model.*
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class NyTimesMapperTest {

    private val sut = NewsMapper

    @Test
    fun `EXPECT values properly mapped WHEN there are no nulls`() {
        val input =
            Results(

                id = "100000008657032".toDouble(),
                publishedDate = "publishedDate",
                updated = "updated",
                section = "section",
                uri = "uri",
                url = "url",
                type = "type",
                title = "title",
                abstract = "abstract"

            )

        val result = sut.map(input)

        with(result) {
            assertThat(id).isEqualTo("100000008657032".toDouble())
            assertThat(publishedDate).isEqualTo("publishedDate")
            assertThat(updated).isEqualTo("updated")
            assertThat(uri).isEqualTo("uri")
            assertThat(url).isEqualTo("url")
            assertThat(type).isEqualTo("type")
            assertThat(title).isEqualTo("title")
            assertThat(abstract).isEqualTo("abstract")
        }
    }

    @Test
    fun `EXPECT default values WHEN fields are null`() {
        val input = Results("100000008657032".toDouble())

        val result = sut.map(input)

        with(result) {
            assertThat(id).isEqualTo("100000008657032".toDouble())
            assertThat(publishedDate).isEmpty()
            assertThat(updated).isEmpty()
            assertThat(uri).isEmpty()
            assertThat(url).isEmpty()
            assertThat(type).isEmpty()
            assertThat(title).isEmpty()
            assertThat(abstract).isEmpty()
        }
    }
}