package com.esosa.ssdbackend.dimensions.fund_type

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "tipo_de_fondo")
data class FundType(
    val nombre: String,

    @Id
    val _id: Int,
)
