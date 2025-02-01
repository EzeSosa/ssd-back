package com.esosa.ssdbackend.facts.orders

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "orden_de_compra")
data class Order(

    val id_proveedor: Int,
    val id_tamaño_insumo: Int,
    val id_tiempo: Int,
    val cantidad_insumos: Double,
    val precio_promedio_ordenes: Double,

    @Id
    val _id: Int,
)