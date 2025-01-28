package com.esosa.ssdbackend.closure_type

import org.springframework.data.mongodb.repository.MongoRepository

interface IClosureTypeRepository : MongoRepository<ClosureType, Int>