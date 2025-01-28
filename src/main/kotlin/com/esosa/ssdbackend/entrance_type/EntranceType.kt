package com.esosa.ssdbackend.entrance_type

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "tipo_de_boca")
data class EntranceType(
    val nombre: String,

    @Id
    val _id: Int,
)