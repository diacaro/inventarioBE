package com.example.inventarioapi.repository
import com.example.inventarioapi.model.Clientes
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ClientesRepository: JpaRepository <Clientes , Long> {
    fun findById (id: Long?): Clientes?

//    @Query(nativeQuery = true)
//    fun listByClientesId (ClientesId: Long?): List<Clientes>
}