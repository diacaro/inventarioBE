package com.example.inventarioapi.service

import com.example.inventarioapi.model.DetalleView
import com.example.inventarioapi.modell.Detalle
import com.example.inventarioapi.repository.DetalleRepository
import com.example.inventarioapi.repository.DetalleViewRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.stereotype.Service


@Service
class  DetalleService {
    @Autowired
    lateinit var detalleRepository: DetalleRepository
    @Autowired
    lateinit var detalleViewRepository: DetalleViewRepository

    fun list (detalle: Detalle):List<Detalle>{
        val matcher = ExampleMatcher.matching()
            .withIgnoreNullValues()
            .withMatcher(("idProductos"), ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
        return detalleRepository.findAll(Example.of(detalle, matcher))
    }


    fun listById (id:Long?):Detalle?{
        return detalleRepository.findById(id)
    }
    fun listProductosId ():List<DetalleView>{
        return detalleViewRepository.findAll()
    }

    fun getDetalleByOrden (idOrden:Long):List <DetalleView> ?{
        return detalleViewRepository.getDetalleByOrden(idOrden)
    }


    fun save (detalle: Detalle):Detalle?{
        return detalleRepository.save(detalle)
    }

    fun update (detalle: Detalle):Detalle?{
        detalleRepository.findById(detalle.id) ?:
        throw Exception()
        return detalleRepository.save(detalle)
    }

    fun delete (id: Long?):Boolean?{
        detalleRepository.findById(id) ?:
            throw Exception()
        detalleRepository.deleteById(id!!)
        return true
    }

}