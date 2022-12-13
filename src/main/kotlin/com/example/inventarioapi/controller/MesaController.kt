package com.example.inventarioapi.controller


import com.example.inventarioapi.model.Invernadero
import com.example.inventarioapi.model.Mesa
import com.example.inventarioapi.service.MesaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/mesa")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
class MesaController {
    @Autowired
    lateinit var mesaService: MesaService

    @GetMapping
    fun list():List<Mesa>{
        return mesaService.list()
    }

    @PostMapping
    fun save(@RequestBody mesa: Mesa): Mesa {
        return mesaService.save (mesa)
    }
    @PutMapping
    fun update (@RequestBody mesa: Mesa): ResponseEntity<Mesa> {
        return  ResponseEntity(mesaService.update(mesa), HttpStatus.OK)
    }

}