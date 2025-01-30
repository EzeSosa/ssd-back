package com.esosa.ssdbackend.dimensions.input

import org.springframework.data.mongodb.repository.MongoRepository

interface IInputRepository : MongoRepository<Input, String>