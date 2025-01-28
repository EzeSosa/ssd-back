package com.esosa.ssdbackend.client

import org.springframework.data.mongodb.repository.MongoRepository

interface IClientRepository : MongoRepository<Client, String>