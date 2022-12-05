package com.example.inventarioapi.repository
import com.example.inventarioapi.model.Mesa
import org.springframework.data.jpa.repository.JpaRepository

interface MesaRepository: JpaRepository<Mesa, Long> {
    fun findById (id: Long?): Mesa?
}