package com.study.kotlin.domain.user

import javax.persistence.*

@Entity
data class User (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(nullable = false)
    var name: String,

    @Column(nullable = false)
    val email: String,

    @Column
    var picture: String,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val role: Role

) {

    fun update (name: String, picture: String): User {
        this.name = name
        this.picture = picture

        return this
    }

    fun getRoleKey(): String {
        return this.role.key
    }

}