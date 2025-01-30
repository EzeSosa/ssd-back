package com.esosa.ssdbackend.dimensions.input

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "insumo")
data class Input(
    val nombre: String,

    @Id
    val _id: Int,
)
