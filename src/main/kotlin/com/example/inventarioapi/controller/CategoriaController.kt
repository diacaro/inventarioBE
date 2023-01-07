package com.example.inventarioapi.controller
import com.example.inventarioapi.model.Categoria
import com.example.inventarioapi.service.CategoriaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/categoria")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])

class CategoriaController {
    @Autowired
    lateinit var categoriaService: CategoriaService

    @GetMapping
    fun list():List<Categoria>{
        return categoriaService.list()
    }

    @PostMapping
    fun save(@RequestBody categoria:Categoria):Categoria{
        return categoriaService.save(categoria)
    }

    fun update (@RequestBody categoria: Categoria): ResponseEntity <Categoria> {
        return  ResponseEntity(categoriaService.update(categoria), HttpStatus.OK)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long): Boolean {
        return categoriaService.delete(id)
    }
}

