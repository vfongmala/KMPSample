package org.vfongmala.kmpsample.repository

import org.vfongmala.kmpsample.SampleResponse

interface SampleRepository {
    fun getSample(): SampleResponse
}

class SampleRepositoryImpl : SampleRepository {
    override fun getSample(): SampleResponse {
        return SampleResponse("Sample")
    }
}