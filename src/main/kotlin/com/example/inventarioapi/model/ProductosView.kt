package com.example.inventarioapi.model

import javax.persistence.*


@Entity
@Table(name="productos_view")
class ProductosView {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var nombre : String? = null
    var clima : String? = null
    var precio : Double? = null

    @Column(name= "id_categoria")
    var idCategoria : Long? = null
    @Column(name= "id_mesa")
    var idMesa : Long? = null

    var categoria : String? = null
    var mesa : String? = null
    var invernadero : String? = null
    var sede : String? = null
}
