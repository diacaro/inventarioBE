package com.example.inventarioapi.model

import javax.persistence.*
@Entity
@Table(name = "detalle_view")
class DetalleView {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @Column(name="id_orden")
    var idOrden: Long? = null
    @Column(name="id_productos")
    var idProductos: Long? = null

}