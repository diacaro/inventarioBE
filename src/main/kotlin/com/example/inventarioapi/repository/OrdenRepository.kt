package com.example.inventarioapi.repository
import com.example.inventarioapi.model.Orden
import org.springframework.data.jpa.repository.JpaRepository

interface OrdenRepository: JpaRepository <Orden , Long> {

    fun findById (id: Long?): Orden?
}