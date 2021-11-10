package com.callor.readbook.model

import javax.persistence.*

@Entity
@Table(name = "tbl_readbook")
data class ReadBookDTO(

    @Id
    @Column(columnDefinition = "BIGINT", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var seq: Long? = 0,

    @Column(nullable = false, columnDefinition = "VARCHAR(13)")
    var isbn: String? = null,

    var title: String? = null,

    var sdate: String? = null,
    var edate: String? = null,

    var stime: String? = null,
    var etime: String? = null,

    var subject: String? = null,

    var content: String? = null,
)