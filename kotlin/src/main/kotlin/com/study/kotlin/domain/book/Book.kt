package com.study.kotlin.domain.book

import com.study.kotlin.exception.NotEnoughStockException
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Getter
import lombok.NoArgsConstructor
import javax.persistence.*

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
data class Book (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(length = 500, nullable = false)
    var title: String,

    @Column(length = 100, nullable = false)
    var author: String,

    @Column(nullable = false)
    var stockQuantity: Int

) {

    /**
     * 책 정보 업데이트
     * @param title
     * @param author
     * @param stockQuantity
     */
    fun update(title: String, author: String, stockQuantity: Int) : Unit{
        this.title = title
        this.author = author
        this.stockQuantity = stockQuantity
    }

    /**
     * stock 증가
     */
    fun addStock(quantity: Int){
        this.stockQuantity += quantity
    }

    /**
     * stock 감소
     */
    fun removeStock(quantity: Int): Unit{
        var restStock: Int = this.stockQuantity - quantity
        if(restStock < 0){
            throw NotEnoughStockException("가능한 대출 권수가 부족합니다.")
        }
        this.stockQuantity = restStock
    }


}