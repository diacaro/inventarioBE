package com.example.inventarioapi.service

import com.example.inventarioapi.model.Categoria
import com.example.inventarioapi.model.Mesa
import com.example.inventarioapi.model.MesaView
import com.example.inventarioapi.model.ProductosView
import com.example.inventarioapi.repository.InvernaderoRepository
import com.example.inventarioapi.repository.MesaRepository
import com.example.inventarioapi.repository.MesaRepositoryView
import com.example.inventarioapi.repository.ProductosRepositoryView
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class MesaService {
    @Autowired
    lateinit var mesaRepository: MesaRepository
    @Autowired
    lateinit var invernaderoRepository: InvernaderoRepository
    @Autowired
    lateinit var mesaRepositoryView: MesaRepositoryView

    fun list ():List <Mesa>{
        return mesaRepository.findAll()
    }

    fun listView ():List <MesaView>{
        return mesaRepositoryView.findAll()
    }

    fun save (mesa: Mesa): Mesa {
        try{

            val response = invernaderoRepository.findById(mesa.idInvernadero)
                ?: throw Exception("El ID ${mesa.idInvernadero} del invernadero no existe")

            return mesaRepository.save(mesa)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }

    }
//        return mesaRepository.save(mesa)


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
    fun delete (id:Long?): Boolean{
        try {
            mesaRepository.findById(id)
                ?: throw Exception("NO existe el ID")
            mesaRepository.deleteById(id!!)
            return true
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

}