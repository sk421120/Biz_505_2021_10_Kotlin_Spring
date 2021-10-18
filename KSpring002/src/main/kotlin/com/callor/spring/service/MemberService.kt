package com.callor.spring.service

import com.callor.spring.model.Member

interface MemberService {
    fun selectAll():Array<Member>
    fun findById(m_id:String):Member
}