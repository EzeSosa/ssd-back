package com.esosa.ssdbackend.dimensions.time

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "tiempo")
data class Time(
    val nombreMes: String?,
    val nombreDia: String?,

    @Id
    val _id: String,
)
