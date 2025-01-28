package com.esosa.ssdbackend.closure_type

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/closure-types")
class ClosureTypeController(
    private val closureTypeRepository: IClosureTypeRepository
) {
    @GetMapping
    fun getClosureTypes(): Collection<ClosureType> = closureTypeRepository.findAll()
}