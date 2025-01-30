package com.esosa.ssdbackend.dimensions.supplier

import org.springframework.data.mongodb.repository.MongoRepository

interface ISupplierRepository : MongoRepository<Supplier, String>