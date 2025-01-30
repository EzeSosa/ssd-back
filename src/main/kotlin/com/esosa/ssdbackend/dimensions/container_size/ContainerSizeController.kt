package com.esosa.ssdbackend.dimensions.container_size

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/container-sizes")
class ContainerSizeController(
    private val containerSizeRepository: IContainerSizeRepository
) {
    @GetMapping
    fun getContainerSizes(): Collection<ContainerSize> = containerSizeRepository.findAll()
}