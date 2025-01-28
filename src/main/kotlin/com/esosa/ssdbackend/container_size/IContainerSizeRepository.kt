package com.esosa.ssdbackend.container_size

import org.springframework.data.mongodb.repository.MongoRepository

interface IContainerSizeRepository : MongoRepository<ContainerSize, String>