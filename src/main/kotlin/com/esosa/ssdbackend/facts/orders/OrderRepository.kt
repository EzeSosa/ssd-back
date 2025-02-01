package com.esosa.ssdbackend.facts.orders

import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Repository

@Repository
class OrderRepository(private val mongoTemplate: MongoTemplate) {
    fun getPriceByDimensions(
        idTiempo: Int,
        idProveedor: Int,
        idTamañoInsumo: Int
    ): Double? {
        val query = buildQuery(idTiempo, idProveedor, idTamañoInsumo)
        return mongoTemplate.findOne(query, Order::class.java)?.precio_promedio_ordenes
    }

    fun getQuantityByDimensions(
        idTiempo: Int,
        idProveedor: Int,
        idTamañoInsumo: Int
    ): Double? {
        val query = buildQuery(idTiempo, idProveedor, idTamañoInsumo)
        return mongoTemplate.findOne(query, Order::class.java)?.cantidad_insumos
    }

    private fun buildQuery(idTiempo: Int, idProveedor: Int, idTamañoInsumo: Int): Query =
        Query().apply {
            addCriteria(Criteria.where("id_tiempo").`is`(idTiempo))
            addCriteria(Criteria.where("id_proveedor").`is`(idProveedor))
            addCriteria(Criteria.where("id_tamaño_insumo").`is`(idTamañoInsumo))
        }
}