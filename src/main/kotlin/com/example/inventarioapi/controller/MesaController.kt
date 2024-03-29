package com.example.inventarioapi.controller


import com.example.inventarioapi.model.Invernadero
import com.example.inventarioapi.model.Mesa
import com.example.inventarioapi.model.MesaView
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
    @GetMapping ("/{id}")
    fun listById(@PathVariable id:Long?): Mesa?{
        return mesaService.listById(id)
    }
    @GetMapping ("/invernadero/{invernaderoId}")
    fun listByInvernadero(@PathVariable("invernaderoId") invernaderoId: Long):List<Mesa>{
        return mesaService.listByInvernaderoId(invernaderoId)
    }
    @GetMapping ("/view/desk")
    fun listView():List<MesaView>{
        return mesaService.listView()
    }

    @PostMapping
    fun save(@RequestBody mesa: Mesa): Mesa {
        return mesaService.save (mesa)
    }
    @PutMapping
    fun update (@RequestBody mesa: Mesa): ResponseEntity<Mesa> {
        return  ResponseEntity(mesaService.update(mesa), HttpStatus.OK)
    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long): Boolean {
        return mesaService.delete(id)
    }

}