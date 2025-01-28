package com.esosa.ssdbackend.fund_type

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/fund-types")
class FundTypeController(
    private val fundTypeRepository: IFundTypeRepository
) {
    @GetMapping
    fun getFundTypes(): Collection<FundType> = fundTypeRepository.findAll()
}