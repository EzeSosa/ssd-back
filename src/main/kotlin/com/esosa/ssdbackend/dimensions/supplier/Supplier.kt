package com.esosa.ssdbackend.dimensions.supplier

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "proveedor")
data class Supplier(
    val nombre_proveedor: String,

    @Id
    val _id: Int,
)
