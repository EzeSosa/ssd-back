package com.esosa.ssdbackend.dimensions.entrance_type

import org.springframework.data.mongodb.repository.MongoRepository

interface IEntranceTypeRepository : MongoRepository<EntranceType, String>