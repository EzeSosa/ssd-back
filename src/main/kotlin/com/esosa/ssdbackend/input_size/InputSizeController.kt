package com.esosa.ssdbackend.input_size

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/input-sizes")
class InputSizeController(
    private val inputSizeRepository: IInputSizeRepository
) {
    @GetMapping
    fun getInputSizes(): Collection<InputSize> = inputSizeRepository.findAll()
}