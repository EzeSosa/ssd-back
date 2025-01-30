package com.esosa.ssdbackend.dimensions.client

import org.springframework.data.mongodb.repository.MongoRepository

interface IClientRepository : MongoRepository<Client, String>