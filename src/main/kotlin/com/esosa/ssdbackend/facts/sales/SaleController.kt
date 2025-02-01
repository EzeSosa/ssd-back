package com.esosa.ssdbackend.facts.sales

import com.esosa.ssdbackend.dimensions.utils.TimeConverter
import com.esosa.ssdbackend.dimensions.utils.TimeUtils
import com.esosa.ssdbackend.query.QueryResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/v1/sales")
class SaleController(
    private val saleRepository: SaleRepository,
    private val timeConverter: TimeConverter,
) {
    companion object {
        const val GANANCIAS_TOTALES: String = "Ganancias Totales"
        const val LOTES_TOTALES: String = "Lotes Vendidos"
    }

    @GetMapping("earnings-by-dimensions")
    fun getEarningsByDimensions(
        @RequestParam("date", required = true) date: String,
        @RequestParam("client", required = true) client: Int,
        @RequestParam("containerSize", required = true) containerSize: Int,
    ): QueryResponse {
        saleRepository.getEarningsByDimensions(
            timeConverter.getTimeIdByDate(TimeUtils.parseIsoDate(date), true).toInt(),
            client,
            containerSize
        )?.let {
            return QueryResponse(
                text = GANANCIAS_TOTALES,
                value = it
            )
        }
        throw ResponseStatusException(HttpStatus.BAD_REQUEST, "No se encontraron ventas para las dimensiones dadas")
    }

    @GetMapping("batches-by-dimensions")
    fun getBatchsByDimension(
        @RequestParam("date", required = true) date: String,
        @RequestParam("closureType", required = true) closureType: Int,
        @RequestParam("entranceType", required = true) entranceType: Int,
        @RequestParam("fundType", required = true) fundType: Int
    ): QueryResponse {
        saleRepository.getBatchQuantityByDimension(
            timeConverter.getTimeIdByDate(TimeUtils.parseIsoDate(date), true).toInt(),
            closureType,
            entranceType,
            fundType
        )?.let {
            return QueryResponse(
                text = LOTES_TOTALES,
                value = it
            )
        }
        throw ResponseStatusException(HttpStatus.BAD_REQUEST, "No se encontraron ventas para las dimensiones dadas")
    }
}