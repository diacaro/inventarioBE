package com.example.inventarioapi.controller
import com.example.inventarioapi.model.Productos
import com.example.inventarioapi.service.ProductosService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/productos")
//La siguiente linea habilita el acceso desde la api
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
class ProductosController {
    @Autowired
    lateinit var productosService: ProductosService



    @GetMapping
    fun list():List<Productos>{
        return productosService.list()
    }

    @PostMapping
    fun save(@RequestBody productos: Productos): Productos {
        return productosService.save (productos)
    }
    @PutMapping
    fun update (@RequestBody productos: Productos): ResponseEntity<Productos> {
        return  ResponseEntity(productosService.update(productos), HttpStatus.OK)
    }

    @PatchMapping ("/updateNombre")
    fun updateNombre (@RequestBody productos: Productos): ResponseEntity<Productos> {
        return  ResponseEntity(productosService.updateNombre(productos), HttpStatus.OK)
    }
    @PatchMapping ("/updateClima")
    fun updateClima (@RequestBody productos: Productos): ResponseEntity<Productos> {
        return  ResponseEntity(productosService.updateClima(productos), HttpStatus.OK)
    }
    @PatchMapping ("/updatePrecio")
    fun updatePrecio (@RequestBody productos: Productos): ResponseEntity<Productos> {
        return  ResponseEntity(productosService.updatePrecio(productos), HttpStatus.OK)
    }
}