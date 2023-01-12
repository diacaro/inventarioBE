package com.example.inventarioapi.controller
import com.example.inventarioapi.model.Clientes
import com.example.inventarioapi.model.Orden
import com.example.inventarioapi.model.OrdenView
import com.example.inventarioapi.service.ClientesService
import com.example.inventarioapi.service.OrdenService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/orden")
//La siguiente linea habilita el acceso desde la api
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])

class OrdenController {
    @Autowired
    lateinit var ordenService: OrdenService

    @GetMapping
    fun list (@RequestHeader headers: HashMap<String, String>,orden:Orden):List <Orden>{
        return ordenService.list(orden)
    }

    @GetMapping("/{id}/clientes")
    fun listClientesByOrden (@PathVariable("id") id: Long): OrdenView{
        return ordenService.getClienteByOrden( id )
    }

    @GetMapping("/last/created")
    fun listLast (): List<OrdenView>{
        return ordenService.listLast()
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): Orden?{
        return ordenService.listById(id)
    }

    @PostMapping
    fun save(@RequestBody orden: Orden): Orden {
        return ordenService.save (orden)
    }
    @PutMapping
    fun update (@RequestBody orden: Orden):  ResponseEntity<Orden> {
        return  ResponseEntity(ordenService.update(orden), HttpStatus.OK)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return ordenService.delete(id)
    }
}
