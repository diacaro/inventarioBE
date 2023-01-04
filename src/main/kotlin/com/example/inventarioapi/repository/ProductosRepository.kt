package com.example.inventarioapi.repository

import com.example.inventarioapi.model.Productos
import org.springframework.data.jpa.repository.JpaRepository

interface ProductosRepository: JpaRepository <Productos , Long> {

    fun findById (id: Long?): Productos?
}