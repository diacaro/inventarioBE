package com.example.inventarioapi.service

import com.example.inventarioapi.model.Categoria
import com.example.inventarioapi.model.Invernadero
import com.example.inventarioapi.model.Mesa
import com.example.inventarioapi.model.Productos
import com.example.inventarioapi.repository.InvernaderoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class InvernaderoService {
    @Autowired
    lateinit var invernaderoRepository: InvernaderoRepository

    fun list ():List <Invernadero>{
        return invernaderoRepository.findAll()
    }
    fun listById (id:Long?):Invernadero? {
        return invernaderoRepository.findById(id)
    }

    fun save (invernadero: Invernadero): Invernadero {
        return invernaderoRepository.save(invernadero)
    }

    fun  update (invernadero: Invernadero): Invernadero {
        try {
            invernaderoRepository.findById(invernadero.id)
                ?: throw Exception("Id Existe")
            return invernaderoRepository.save(invernadero)
        }
        catch (ex: Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun  updateSede (invernadero: Invernadero): Invernadero {
        try {
            val response = invernaderoRepository.findById(invernadero.id)
                ?: throw Exception("Id Existe")
            response.apply {
                sede= invernadero.sede
            }
            return invernaderoRepository.save(response)
        }
        catch (ex: Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun delete (id:Long?): Boolean {
        try {
            invernaderoRepository.findById(id)
                ?: throw Exception("El invernadero no existe")
            invernaderoRepository.deleteById(id!!)
            return true
        } catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex
            )
        }
    }

}