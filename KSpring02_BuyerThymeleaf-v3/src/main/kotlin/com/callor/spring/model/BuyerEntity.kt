package com.callor.spring.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "tbl_buyer", schema = "naraDB")
class BuyerEntity {

    @Id
    @Column(columnDefinition = "CHAR(4)", nullable = false)
    private val m_id: String? = null

    @Column(columnDefinition = "VARCHAR(25)", nullable = false)
    private val m_name: String? = null

    @Column(columnDefinition = "VARCHAR(25)", nullable = false)
    private val m_tel: String? = null

    @Column(nullable = false)
    private val m_addr: String? = null

    @Column(columnDefinition = "VARCHAR(25)", nullable = false)
    private val m_man: String? = null

    @Column(columnDefinition = "VARCHAR(25)", nullable = false)
    private val m_manTel:String? = null

    @Column(columnDefinition = "CHAR(4)", nullable = false)
    private val m_total:Int = 0
}