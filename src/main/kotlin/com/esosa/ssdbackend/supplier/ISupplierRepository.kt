package com.esosa.ssdbackend.supplier

import org.springframework.data.mongodb.repository.MongoRepository

interface ISupplierRepository : MongoRepository<Supplier, String>