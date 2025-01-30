package com.esosa.ssdbackend.facts.sale

import com.esosa.ssdbackend.dimensions.utils.TimeUtils
import com.esosa.ssdbackend.query.EarningsRequest
import com.esosa.ssdbackend.query.QueryResponse
import com.esosa.ssdbackend.query.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/sales")
class SaleController(
    private val saleRepository: ISaleRepository,
    private val timeUtils: TimeUtils,
) {
    @GetMapping
    fun getEarningsByDimensions(@RequestBody earningsRequest: EarningsRequest): QueryResponse =
        with(earningsRequest) {
            return QueryResponse(
                text = "Ganancias totales: ",
                value = Value.DoubleValue(saleRepository.getEarningsByDimensions(
                    timeUtils.getTimeIdByDate(date, true), client, containerSize
                ))
            )
        }
}