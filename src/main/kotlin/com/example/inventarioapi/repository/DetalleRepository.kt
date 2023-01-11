package com.example.inventarioapi.repository

import com.example.inventarioapi.modell.Detalle
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DetalleRepository : JpaRepository<Detalle, Long?> {
    fun findById (id: Long?): Detalle?

//    fun findByOrdenIdAndProductId (idOrden: Long?,idProductos: Long?):  Detalle?


}