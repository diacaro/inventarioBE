package com.example.inventarioapi.repository
import com.example.inventarioapi.model.Mesa
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface MesaRepository: JpaRepository<Mesa, Long> {
    fun findById (id: Long?): Mesa?

    @Query(nativeQuery = true)
    fun ListByInvernaderoId (idInvernadero: Long?): List<Mesa>


}