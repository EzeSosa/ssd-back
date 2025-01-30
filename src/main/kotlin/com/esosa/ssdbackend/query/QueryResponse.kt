package com.esosa.ssdbackend.query

sealed class Value {
    data class IntValue(val value: Int) : Value()
    data class StringValue(val value: String) : Value()
    data class DoubleValue(val value: Double) : Value()
}

data class QueryResponse(
    val text: String,
    val value: Value,
)
