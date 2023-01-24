package com.example.inventarioapi.model

import javax.persistence.*
@Entity
@Table(name = "detalle_view")
class DetalleView {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var cantidad : Double? = null
    @Column(name="id_orden")
    var idOrden: Long? = null
    @Column(name="id_productos")
    var idProductos: Long? = null
    var nombre : String? = null
    var mesa : String? = null
    var invernadero : String? = null

}

//cant
//nombre (producto)
//mesa
//invernadero
