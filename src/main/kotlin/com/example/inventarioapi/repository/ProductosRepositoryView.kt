package com.example.inventarioapi.repository

import com.example.inventarioapi.model.ProductosView
import org.springframework.data.jpa.repository.JpaRepository

interface ProductosRepositoryView: JpaRepository <ProductosView , Long> {

    fun findById (id: Long?): ProductosView?
}