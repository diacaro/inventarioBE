package com.example.inventarioapi.repository


import com.example.inventarioapi.model.OrdenView
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface OrdenViewRepository : JpaRepository<OrdenView, Long?> {
    fun findById (id: Long?): OrdenView?

    @Query(nativeQuery = true)
    fun getClienteByOrdenId (@Param("id") id:Long): OrdenView

    @Query(nativeQuery = true)
    fun listLastTen (): List<OrdenView>

    @Query(nativeQuery = true)
    fun listByFullname (@Param("word") word:String): List<OrdenView>
}