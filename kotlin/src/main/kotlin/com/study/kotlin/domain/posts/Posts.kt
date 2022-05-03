package com.study.kotlin.domain.posts

import com.study.kotlin.domain.user.User
import lombok.Getter
import lombok.NoArgsConstructor
import javax.persistence.*

@Entity
@NoArgsConstructor
@Getter
data class Posts (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(length = 500, nullable = false)
    var title: String,

    @Column(columnDefinition = "TEXT", nullable = false)
    var content: String,

    val writer: Long,

    @OneToOne
    @JoinColumn(name = "id")
    val user: User

){
    fun update(title: String, content: String): Unit{
        this.title = title
        this.content = content
    }
}