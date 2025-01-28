package com.esosa.ssdbackend.client

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/clients")
class ClientController(
    private val clientRepository: IClientRepository,
) {
    @GetMapping
    fun getClients(): Collection<Client> = clientRepository.findAll()
}