package com.esosa.ssdbackend.dimensions.input_size

import org.springframework.data.mongodb.repository.MongoRepository

interface IInputSizeRepository : MongoRepository<InputSize, String>