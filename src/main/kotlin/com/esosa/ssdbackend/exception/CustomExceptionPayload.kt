package com.esosa.ssdbackend.exception

import java.time.LocalDateTime

data class CustomExceptionPayload(
    val message: String,
    val status: Int,
    val timestamp: LocalDateTime,
)
