package com.callor.spring.service

import com.callor.spring.model.Buyer

interface BuyerService {
    fun selectAll():Array<Buyer>
    fun findById(m_id:String):Buyer
    fun findByName(m_name:String):Array<Buyer>
    fun findByTel(m_tel:String): Array<Buyer>

    fun insert(buyer:Buyer):Buyer
    fun delete(m_id:String):Buyer
    fun update(buyer:Buyer):Buyer
}