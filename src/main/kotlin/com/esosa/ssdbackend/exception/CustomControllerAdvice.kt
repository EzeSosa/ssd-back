package com.esosa.ssdbackend.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.server.ResponseStatusException
import java.time.LocalDateTime

@RestControllerAdvice
class CustomControllerAdvice {

    @ExceptionHandler(ResponseStatusException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleResponseStatusException(ex: ResponseStatusException): CustomExceptionPayload =
        CustomExceptionPayload(
            message = ex.reason ?: "Ocurrió un error",
            status = ex.statusCode.value(),
            timestamp = LocalDateTime.now()
        )
}