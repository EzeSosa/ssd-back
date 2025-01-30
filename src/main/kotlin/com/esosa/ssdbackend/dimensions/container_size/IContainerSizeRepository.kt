package com.esosa.ssdbackend.dimensions.container_size

import org.springframework.data.mongodb.repository.MongoRepository

interface IContainerSizeRepository : MongoRepository<ContainerSize, String>