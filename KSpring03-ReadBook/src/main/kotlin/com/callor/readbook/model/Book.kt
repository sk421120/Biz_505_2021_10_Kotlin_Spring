package com.callor.readbook.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "tbl_book", schema = "naraDB")
data class Book(

    @Id
    @Column(
        columnDefinition = "CHAR(13)",
        nullable = false,
        unique = true
    )
    var isbn: String? = null,

    @Column(nullable = false)
    var title: String? = null,

//    @Column(nullable = false)
    var comp: String? = null,

//    @Column(nullable = false)
    var author: String? = null,

    @Column(nullable = false)
    var price: Int? = 0
)