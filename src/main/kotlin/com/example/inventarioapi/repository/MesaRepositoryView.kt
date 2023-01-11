package com.example.inventarioapi.repository
import com.example.inventarioapi.model.MesaView
import org.springframework.data.jpa.repository.JpaRepository

interface MesaRepositoryView: JpaRepository<MesaView, Long> {
    fun findById (id: Long?): MesaView?
}
