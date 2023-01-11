package com.example.inventarioapi.model

import java.util.Date
import javax.persistence.*
@Entity
@Table(name = "orden")
class OrdenView {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @Column(name="create_at")
    var createAt: Date? = null
    @Column(name="id_clientes")
    var id_clientes: String? = null
    var clientes: String? = null

}