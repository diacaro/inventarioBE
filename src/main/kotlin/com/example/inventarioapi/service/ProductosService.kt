package com.example.inventarioapi.service

import com.example.inventarioapi.model.Productos
import com.example.inventarioapi.model.ProductosView
import com.example.inventarioapi.repository.ProductosRepository
import com.example.inventarioapi.repository.ProductosRepositoryView
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ProductosService {

    @Autowired
    lateinit var productosRepository: ProductosRepository
    @Autowired
    lateinit var productosRepositoryView: ProductosRepositoryView

    fun list ():List <Productos>{
        return productosRepository.findAll()
    }
    fun listById (id:Long?):Productos? {
        return productosRepository.findById(id)
    }
    fun listView ():List <ProductosView>{
        return productosRepositoryView.findAll()
    }

    fun save (productos: Productos): Productos{
        return productosRepository.save(productos)
    }


    fun  update (productos: Productos): Productos {
        try {
            productosRepository.findById(productos.id)

                ?: throw Exception("Id Existe")

            return productosRepository.save(productos)
        }
        catch (ex: Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }


    fun  updateNombre (productos: Productos): Productos {
        try {
            val response = productosRepository.findById(productos.id)
                ?: throw Exception("Id Existe")
            response.apply {
                nombre= productos.nombre
            }
            return productosRepository.save(response)
        }
        catch (ex: Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun  updateClima (productos: Productos): Productos {
        try {
            val response = productosRepository.findById(productos.id)
                ?: throw Exception("Id Existe")
            response.apply {
                clima= productos.clima
            }
            return productosRepository.save(response)
        }
        catch (ex: Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun  updatePrecio (productos: Productos): Productos {
        try {
            val response = productosRepository.findById(productos.id)
                ?: throw Exception("Id Existe")
            response.apply {
                precio= productos.precio
            }
            return productosRepository.save(response)
        }
        catch (ex: Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun  updateCantidad (productos: Productos): Productos {
        try {
            val response = productosRepository.findById(productos.id)
                ?: throw Exception("Id Existe")
            response.apply {
                cantidad= productos.cantidad
            }
            return productosRepository.save(response)
        }
        catch (ex: Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun delete (id:Long?): Boolean{
        try {
            productosRepository.findById(id)
                ?: throw Exception("NO existe el ID")
            productosRepository.deleteById(id!!)
            return true
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

}