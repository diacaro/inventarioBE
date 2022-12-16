package com.example.inventarioapi.model

import javax.persistence.*

@Entity
@Table(name="mesa")
class Mesa {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var mesa : String? = null
    @Column(name= "id_invernadero")
    var idInvernadero : Long? = null
}