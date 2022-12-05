package com.example.inventarioapi.model
import javax.persistence.*


@Entity
@Table(name="invernadero")
class Invernadero {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var invernadero: String? = null
    var sede: String? = null

}