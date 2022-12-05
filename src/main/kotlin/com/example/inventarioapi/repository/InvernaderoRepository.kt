package com.example.inventarioapi.repository
import com.example.inventarioapi.model.Invernadero
import org.springframework.data.jpa.repository.JpaRepository

interface InvernaderoRepository: JpaRepository<Invernadero, Long> {
    fun findById (id: Long?): Invernadero?
}