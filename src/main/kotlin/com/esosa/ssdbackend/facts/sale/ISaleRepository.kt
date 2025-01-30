package com.esosa.ssdbackend.facts.sale

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query

interface ISaleRepository : MongoRepository<Sale, Int> {

    @Query(
        value = "{ 'id_tiempo': ?0,'id_ciente':  ?1, 'id_tamaño_insumo': ?2 }",
        fields = "{ 'total_ganancias': 1, '_id': 0 }"
    )
    fun getEarningsByDimensions(
        id_tiempo: String,
        id_cliente: Int,
        id_tamaño_insumo: Int
    ): Double
}