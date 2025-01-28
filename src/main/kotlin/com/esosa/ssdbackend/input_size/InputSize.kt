package com.esosa.ssdbackend.input_size

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "tamaño_insumo")
data class InputSize(
    val nombre_tamaño_insumo: String,

    @Id
    val _id: Int,
)
