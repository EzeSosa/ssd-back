package com.esosa.ssdbackend.input

import org.springframework.data.mongodb.repository.MongoRepository

interface IInputRepository : MongoRepository<Input, String>