package com.esosa.ssdbackend.facts.sales

import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Repository

@Repository
class SaleRepository(private val mongoTemplate: MongoTemplate) {
    fun getEarningsByDimensions(
        idTiempo: Int,
        idCliente: Int,
        idTamañoTipoEnvase: Int
    ): Double? {
        val query = Query().apply {
            addCriteria(Criteria.where("id_tiempo").`is`(idTiempo))
            addCriteria(Criteria.where("id_ciente").`is`(idCliente))
            addCriteria(Criteria.where("id_tamaño_tipo_envase").`is`(idTamañoTipoEnvase))
        }
        return mongoTemplate.findOne(query, Sale::class.java)?.total_ganancias
    }

    fun getBatchQuantityByDimension(
        idTiempo: Int,
        idTipoDeCierre: Int,
        idTipoDeBoca: Int,
        idTipoDeFondo: Int
    ): Double? {
        val query = Query().apply {
            addCriteria(Criteria.where("id_tiempo").`is`(idTiempo))
            addCriteria(Criteria.where("id_tipo_de_cierre").`is`(idTipoDeCierre))
            addCriteria(Criteria.where("id_tipo_de_boca").`is`(idTipoDeBoca))
            addCriteria(Criteria.where("id_tipo_de_fondo").`is`(idTipoDeFondo))
        }
        return mongoTemplate.findOne(query, Sale::class.java)?.cantidad_lotes_vendidos
    }
}