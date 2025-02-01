package com.esosa.ssdbackend.facts.productions

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "orden_de_produccion")
data class Production(
    val id_ciente: Int,
    val id_insumo: Int,
    val id_tiempo: Int,
    val cantidad_tipos_envase: Double,

    @Id
    val _id: Int,
)
