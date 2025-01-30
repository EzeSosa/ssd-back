package com.esosa.ssdbackend.dimensions.entrance_type

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/entrance-types")
class EntranceTypeController(
    private val entranceTypeRepository: IEntranceTypeRepository
) {
    @GetMapping
    fun getEntranceTypes(): Collection<EntranceType> = entranceTypeRepository.findAll()
}