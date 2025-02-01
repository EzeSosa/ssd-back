package com.esosa.ssdbackend.dimensions.utils

import com.esosa.ssdbackend.dimensions.time.ITimeRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.server.ResponseStatusException
import java.time.LocalDate

@Component
class TimeConverter(private val timeRepository: ITimeRepository) {
    fun getTimeIdByDate(date: LocalDate, isMonth: Boolean): String {
        return if (isMonth)
            MONTH_MAP[date.month.value]?.let { timeRepository.findByNombreMes(it)?._id }
                ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST)
        else
            timeRepository.findByNumeroDia(date.dayOfMonth)?._id
                ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST)
    }
}