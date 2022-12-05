package com.example.inventarioapi.repository

import com.example.inventarioapi.model.Categoria
import org.springframework.data.jpa.repository.JpaRepository

interface CategoriaRepository:JpaRepository<Categoria,Long> {

    fun findById (id: Long?):Categoria?



}