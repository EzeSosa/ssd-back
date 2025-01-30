package com.esosa.ssdbackend.query

import java.time.LocalDate

data class EarningsRequest(
    val date: LocalDate,
    val client: Int,
    val containerSize: Int,
)
