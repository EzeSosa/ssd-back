package com.esosa.ssdbackend.closure_type

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "tipo_de_cierre")
data class ClosureType(
    val nombre: String,

    @Id
    val _id: Int,
)
