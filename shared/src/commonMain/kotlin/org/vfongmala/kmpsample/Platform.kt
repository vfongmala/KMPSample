package org.vfongmala.kmpsample

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform