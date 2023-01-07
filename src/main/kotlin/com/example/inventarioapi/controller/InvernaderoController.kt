package com.example.inventarioapi.controller

import com.example.inventarioapi.model.Categoria
import com.example.inventarioapi.model.Invernadero
import com.example.inventarioapi.service.InvernaderoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/invernadero")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
class InvernaderoController {
    @Autowired
    lateinit var invernaderoService: InvernaderoService

    @GetMapping
    fun list():List<Invernadero>{
        return invernaderoService.list()
    }

    @PostMapping
    fun save(@RequestBody invernadero: Invernadero): Invernadero {
        return invernaderoService.save(invernadero)
    }

    @PutMapping
    fun update (@RequestBody invernadero: Invernadero): ResponseEntity<Invernadero> {
        return  ResponseEntity(invernaderoService.update(invernadero), HttpStatus.OK)
    }

    @PatchMapping
    fun updateSede (@RequestBody invernadero: Invernadero): ResponseEntity<Invernadero> {
        return  ResponseEntity(invernaderoService.updateSede(invernadero), HttpStatus.OK)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long): Boolean {
        return invernaderoService.delete(id)
    }

}