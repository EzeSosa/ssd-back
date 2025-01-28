package com.esosa.ssdbackend.input

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/inputs")
class InputController(
    private val inputRepository: IInputRepository
) {
    @GetMapping
    fun getInputs(): Collection<Input> = inputRepository.findAll()
}