package com.example.inventarioapi.service

import com.example.inventarioapi.model.Categoria
import com.example.inventarioapi.model.Mesa
import com.example.inventarioapi.repository.MesaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class MesaService {
    @Autowired
    lateinit var mesaRepository: MesaRepository

    fun list ():List <Mesa>{
        return mesaRepository.findAll()
    }

    fun save (mesa: Mesa): Mesa {
        return mesaRepository.save(mesa)
    }

    fun  update (mesa: Mesa): Mesa {
        try {
            mesaRepository.findById(mesa.id)
                ?: throw Exception("Id Existe")
            return mesaRepository.save(mesa)
        }
        catch (ex: Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

}