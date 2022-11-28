package com.demo.nytimes.domain.model

sealed class GetNewsError {
    object NoNewsFound: GetNewsError()
    object GenericError: GetNewsError()
}