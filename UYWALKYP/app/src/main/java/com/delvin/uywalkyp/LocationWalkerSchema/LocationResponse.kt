package com.delvin.uywalkyp.LocationWalkerSchema

data class LocationResponse(
    val id_locacion_paseador: Int,
    val latitud: Double,
    val longitud: Double,
    val usuarioId: Int
)