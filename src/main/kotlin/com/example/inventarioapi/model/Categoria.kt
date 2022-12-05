package com.example.inventarioapi.model

import javax.persistence.*

@Entity
@Table(name="categoria")
class Categoria {
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Id
    @Column (updatable = false)
    var id: Long? = null
    var categoria :  String? = null

}