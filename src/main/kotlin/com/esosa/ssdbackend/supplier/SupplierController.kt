package com.esosa.ssdbackend.supplier

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/suppliers")
class SupplierController(
    private val supplierRepository: ISupplierRepository,
) {
    @GetMapping
    fun getSuppliers(): Collection<Supplier> = supplierRepository.findAll()
}