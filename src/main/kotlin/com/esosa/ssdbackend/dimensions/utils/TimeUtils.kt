package com.esosa.ssdbackend.dimensions.utils

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class TimeUtils {
    companion object {
        fun parseIsoDate(dateString: String): LocalDate =
            LocalDateTime.parse(dateString, DateTimeFormatter.ISO_DATE_TIME)
                .toLocalDate()
    }
}