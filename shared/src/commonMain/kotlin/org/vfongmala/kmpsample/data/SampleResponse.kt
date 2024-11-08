package org.vfongmala.kmpsample.data

import kotlinx.serialization.*

@Serializable
data class SampleResponse(
    val message: String,
)