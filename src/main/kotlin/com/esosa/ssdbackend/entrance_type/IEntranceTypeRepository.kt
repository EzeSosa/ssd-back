package com.esosa.ssdbackend.entrance_type

import org.springframework.data.mongodb.repository.MongoRepository

interface IEntranceTypeRepository : MongoRepository<EntranceType, String>