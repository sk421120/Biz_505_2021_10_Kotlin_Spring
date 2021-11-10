package com.callor.readbook.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "tbl_book")
data class BookDTO(

    @Id
    @Column(
        columnDefinition = "VARCHAR(13)", nullable = false,
    )
    var isbn: String? = null,

    @Column(nullable = false, columnDefinition = "VARCHAR(125)")
    var title: String? = null,

    var comp: String? = null,

    var author: String? = null,

    var price: Int? = 0
)