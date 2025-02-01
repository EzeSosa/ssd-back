package com.esosa.ssdbackend.facts.productions

import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Repository

@Repository
class ProductionRepository(private val mongoTemplate: MongoTemplate) {
    fun getContainersByDimensions(
        idTiempo: Int,
        idCliente: Int,
        idInsumo: Int
    ): Double? {
        val query = Query().apply {
            addCriteria(Criteria.where("id_tiempo").`is`(idTiempo))
            addCriteria(Criteria.where("id_ciente").`is`(idCliente))
            addCriteria(Criteria.where("id_insumo").`is`(idInsumo))
        }
        return mongoTemplate.findOne(query, Production::class.java)?.cantidad_tipos_envase
    }
}