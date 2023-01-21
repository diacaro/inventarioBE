package com.example.inventarioapi.service

import com.example.inventarioapi.model.Clientes
import com.example.inventarioapi.model.Mesa
import com.example.inventarioapi.repository.ClientesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ClientesService {

    @Autowired
    lateinit var clientesRepository: ClientesRepository

    fun list ():List <Clientes>{
        return clientesRepository.findAll()
    }
    fun listById (id:Long?):Clientes? {
        return clientesRepository.findById(id)
    }
//    fun listView ():List <ProductosView>{
//        return productosRepositoryView.findAll()
//    }
//    fun listByClientesId (id:Long?):List <Clientes> {
//        return clientesRepository.listByClientesId(id)
//    }

    fun save (clientes: Clientes): Clientes{
        return clientesRepository.save(clientes)
    }


    fun  update (clientes: Clientes): Clientes {
        try {
            clientesRepository.findById(clientes.id)

                ?: throw Exception("Id Existe")

            return clientesRepository.save(clientes)
        }
        catch (ex: Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }


    fun  updateFullname (clientes: Clientes): Clientes {
        try {
            val response = clientesRepository.findById(clientes.id)
                ?: throw Exception("Id Existe")
            response.apply {
                fullname= clientes.fullname
            }
            return clientesRepository.save(response)
        }
        catch (ex: Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun  updatePhone (clientes: Clientes): Clientes {
        try {
            val response = clientesRepository.findById(clientes.id)
                ?: throw Exception("Id Existe")
            response.apply {
                phone= clientes.phone
            }
            return clientesRepository.save(response)
        }
        catch (ex: Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun  updateAddress (clientes: Clientes): Clientes {
        try {
            val response = clientesRepository.findById(clientes.id)
                ?: throw Exception("Id Existe")
            response.apply {
                address= clientes.address
            }
            return clientesRepository.save(response)
        }
        catch (ex: Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun delete (id:Long?): Boolean{
        try {
            clientesRepository.findById(id)
                ?: throw Exception("NO existe el ID")
            clientesRepository.deleteById(id!!)
            return true
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

}