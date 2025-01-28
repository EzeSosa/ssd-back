package com.esosa.ssdbackend.container_size

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "tamaño_tipo_envase")
data class ContainerSize(

    val largo: Int,
    val ancho: Int,
    val alto: Int,

    @Id
    val _id: Int,
)
