package com.esosa.ssdbackend.facts.productions

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
@RequestMapping("/v1/productions")
class ProductionController(private val productionRepository: ProductionRepository, private val timeConverter: TimeConverter) {
    companion object {
        const val CANTIDAD_TIPOS_ENVASES: String = "Cantidad de Tipos de Envases"
    }

    @GetMapping("container-types")
    fun getContainerTypesByDimensions(
        @RequestParam("date", required = true) date: String,
        @RequestParam("client", required = true) client: Int,
        @RequestParam("input", required = true) input: Int,
    ): QueryResponse {
        println(timeConverter.getTimeIdByDate(TimeUtils.parseIsoDate(date), false))

        productionRepository.getContainersByDimensions(
            timeConverter.getTimeIdByDate(TimeUtils.parseIsoDate(date), false).toInt(),
            client,
            input
        )?.let {
            return QueryResponse(
                text = CANTIDAD_TIPOS_ENVASES,
                value = it
            )
        }
        throw ResponseStatusException(HttpStatus.BAD_REQUEST, "No se encontraron producciones para las dimensiones dadas")
    }
}