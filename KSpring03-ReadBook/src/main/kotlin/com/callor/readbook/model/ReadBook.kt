package com.callor.readbook.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "tbl_readbook", schema = "naraDB")
data class ReadBook(

    @Id
    @Column(columnDefinition = "BIGINT")
    var seq: Long? = null,

    @Column(nullable = false)
    var isbn: String? = null,

    @Column(nullable = false)
    var rdate: String? = null,

    var stime: String? = null,

    var etime: String? = null,

    @Column(nullable = false)
    var rating: Int? = 0,

    var comment: String? = null
)