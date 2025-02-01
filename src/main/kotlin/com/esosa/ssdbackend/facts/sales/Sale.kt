package com.esosa.ssdbackend.facts.sales

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "venta")
data class Sale(

    val id_ciente: Int,
    val id_tamaño_tipo_envase: Int,
    val id_tipo_de_fondo: Int,
    val id_tipo_de_cierre: Int,
    val id_tipo_de_boca: Int,
    val id_tiempo: Int,
    val cantidad_lotes_vendidos: Double,
    val total_ganancias: Double,

    @Id
    val _id: Int,
)
