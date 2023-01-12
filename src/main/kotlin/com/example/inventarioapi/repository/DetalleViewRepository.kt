package com.example.inventarioapi.repository
import com.example.inventarioapi.model.DetalleView
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface DetalleViewRepository : JpaRepository<DetalleView, Long?> {
    fun findById (id: Long?): DetalleView?

    @Query(nativeQuery = true)
    fun getDetalleByOrden(@Param("idOrden") idOrden:Long): List<DetalleView>
}