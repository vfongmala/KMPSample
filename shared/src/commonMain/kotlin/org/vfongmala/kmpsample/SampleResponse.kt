package org.vfongmala.kmpsample

import kotlinx.serialization.*

@Serializable
data class SampleResponse(
    val message: String,
)