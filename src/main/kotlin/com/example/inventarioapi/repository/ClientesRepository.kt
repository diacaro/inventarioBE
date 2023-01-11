package com.example.inventarioapi.repository

import com.example.inventarioapi.model.Clientes
import org.springframework.data.jpa.repository.JpaRepository

interface ClientesRepository: JpaRepository <Clientes , Long> {

    fun findById (id: Long?): Clientes?
}