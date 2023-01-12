package com.example.inventarioapi.service

import com.example.inventarioapi.model.Orden
import com.example.inventarioapi.model.OrdenView
import com.example.inventarioapi.repository.OrdenRepository
import com.example.inventarioapi.repository.OrdenViewRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.stereotype.Service


@Service
class OrdenService {

    @Autowired
    lateinit var ordenRepository: OrdenRepository
    @Autowired
    lateinit var ordenViewRepository: OrdenViewRepository

    fun list (orden:Orden):List<Orden>{
        val matcher = ExampleMatcher.matching()
            .withIgnoreNullValues()
            .withMatcher(("idClientes"), ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
        return ordenRepository.findAll(Example.of(orden, matcher))
    }

    fun listById (id:Long?):Orden? {
        return ordenRepository.findById(id)
    }

//    fun listInvoiceAmbience ():List<OrdenView>{
//        return ordenViewRepository.findAll()
//    }

    fun listByFullName (word:String):List<OrdenView>{
        return ordenViewRepository.listByFullname(word)
    }

    fun listLast ():List<OrdenView>{
        return ordenViewRepository.listLastTen()
    }


    fun save (orden: Orden): Orden{
        return ordenRepository.save(orden)
    }


    fun update (orden: Orden):Orden?{
        ordenRepository.findById(orden.id) ?:
        throw Exception()
        return ordenRepository.save(orden)
    }

    fun getClienteByOrden (id:Long):OrdenView{
        return ordenViewRepository.getClienteByOrden(id)
    }

    fun delete (id: Long?):Boolean?{
        ordenRepository.findById(id) ?:
        Exception()
        ordenRepository.deleteById(id!!)
        return true
    }

}