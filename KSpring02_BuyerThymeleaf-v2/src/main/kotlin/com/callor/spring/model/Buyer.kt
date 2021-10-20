package com.callor.spring.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

/**
 * DTO(VO) 클래스
 */
@Entity
@Table(name = "tbl_buyer", schema = "naraDB")
data class Buyer(

    @Id
    @Column(columnDefinition = "CHAR(4)", nullable = false, unique = true, name = "m_id")
    var m_id: String,

    @Column(columnDefinition = "VARCHAR(25)", nullable = false)
    var m_name: String,

    @Column(columnDefinition = "VARCHAR(25)", nullable = true)
    var m_tel: String,

    @Column(nullable = true)
    var m_addr: String,

    @Column(columnDefinition = "VARCHAR(25)", nullable = true)
    var m_man: String,

    @Column(columnDefinition = "VARCHAR(25)", nullable = true)
    var m_manTel:String,

    @Column(columnDefinition = "CHAR(4)", nullable = true)
    var m_total:Int? = 0
)