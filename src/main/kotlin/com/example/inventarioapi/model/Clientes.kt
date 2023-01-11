package com.example.inventarioapi.model

import javax.persistence.*


@Entity
@Table(name="clientes")
class Clientes {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var fullname : String? = null
    var phone : String? = null
    var address : String? = null
}