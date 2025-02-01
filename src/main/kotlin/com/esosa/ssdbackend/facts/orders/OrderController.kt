package com.esosa.ssdbackend.facts.orders

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
@RequestMapping("/v1/orders")
class OrderController(private val orderRepository: OrderRepository, private val timeConverter: TimeConverter) {
    companion object {
        const val PROMEDIO_ORDENES: String = "Precio Promedio de Órdenes"
        const val CANTIDAD_INSUMOS: String = "Cantidad de Insumos"
    }

    @GetMapping("average-orders")
    fun getAveragePriceByDimensions(
        @RequestParam("date", required = true) date: String,
        @RequestParam("supplier", required = true) proveedor: Int,
        @RequestParam("inputSize", required = true) tamañoInsumo: Int,
    ): QueryResponse {
        orderRepository.getPriceByDimensions(
            timeConverter.getTimeIdByDate(TimeUtils.parseIsoDate(date), true).toInt(),
            proveedor,
            tamañoInsumo
        )?.let {
            return QueryResponse(
                text = PROMEDIO_ORDENES,
                value = it
            )
        }
        throw ResponseStatusException(HttpStatus.BAD_REQUEST, "No se encontraron compras para las dimensiones dadas")
    }

    @GetMapping("input-quantity")
    fun getInputQuantityByDimensions(
        @RequestParam("date", required = true) date: String,
        @RequestParam("supplier", required = true) proveedor: Int,
        @RequestParam("inputSize", required = true) tamañoInsumo: Int,
    ): QueryResponse {
        orderRepository.getQuantityByDimensions(
            timeConverter.getTimeIdByDate(TimeUtils.parseIsoDate(date), false).toInt(),
            proveedor,
            tamañoInsumo
        )?.let {
            return QueryResponse(
                text = CANTIDAD_INSUMOS,
                value = it
            )
        }
        throw ResponseStatusException(HttpStatus.BAD_REQUEST, "No se encontraron compras para las dimensiones dadas")
    }
}