package com.esosa.ssdbackend.client

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "cliente")
data class Client(
    val cuil: String,

    @Id
    val _id: Int,
)