package com.demo.nytimes.domain.service

internal object OrganisationValidator {

    fun isValidOrganisation(organisation: String): Boolean {
        return organisation.length >= 2
    }

}