package com.example.inventarioapi.controller
import com.example.inventarioapi.model.Productos
import com.example.inventarioapi.model.ProductosView
import com.example.inventarioapi.service.ProductosService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
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

    @GetMapping ("/{id}")
    fun listById(@PathVariable id:Long?):Productos?{
        return productosService.listById(id)
    }
    @GetMapping ("/view/full")
    fun listView():List<ProductosView>{
        return productosService.listView()
    }

    @GetMapping("/page")
    fun listPage (productos: Productos, pageable: Pageable):ResponseEntity<*>{
        val response= productosService.listPageable(pageable,productos)
        return ResponseEntity(response, HttpStatus.OK)
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
    @PatchMapping ("/updateCantidad")
    fun updateCantidad (@RequestBody productos: Productos): ResponseEntity<Productos> {
        return  ResponseEntity(productosService.updateCantidad(productos), HttpStatus.OK)
    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long): Boolean {
        return productosService.delete(id)
    }
}
