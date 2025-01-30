package com.esosa.ssdbackend.dimensions.time

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query

interface ITimeRepository : MongoRepository<Time, String> {
    @Query(value = "{ 'nombreMes': ?0 }")
    fun findByNombreMes(nombreMes: String): Time?

    @Query(value = "{ 'numeroDia': ?0 }")
    fun findByNumeroDia(numeroDia: Int): Time?
}