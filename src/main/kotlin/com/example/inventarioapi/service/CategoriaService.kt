package com.example.inventarioapi.service

import com.example.inventarioapi.model.Categoria
import com.example.inventarioapi.repository.CategoriaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class CategoriaService {

    @Autowired
    lateinit var categoriaRepository: CategoriaRepository

    fun list ():List <Categoria>{
        return categoriaRepository.findAll()
    }

    fun save (categoria:Categoria):Categoria{
        return categoriaRepository.save(categoria)
    }

    fun  update (categoria: Categoria):Categoria{
        try {
            categoriaRepository.findById(categoria.id)
                ?: throw Exception("Id Existe")
            return categoriaRepository.save(categoria)
        }
        catch (ex: Exception){
        throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun delete (id:Long?): Boolean{
        try {
            categoriaRepository.findById(id)
                ?: throw Exception("La categoria no existe")
            categoriaRepository.deleteById(id!!)
            return true
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

//    fun  updateCategoria (categoria:Categoria):Categoria{
//        try {
//            val response = categoriaRepository.findById(categoria.id)
//                ?: throw Exception("Id Existe")
//            response.apply {
//                categoria= categoria.categoria
//            }
//            return categoriaRepository.save(response)
//        }
//        catch (ex: Exception){
//            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
//        }
//    }
    }