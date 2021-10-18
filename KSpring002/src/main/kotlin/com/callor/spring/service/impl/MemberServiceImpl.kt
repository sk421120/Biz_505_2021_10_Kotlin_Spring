package com.callor.spring.service.impl

import com.callor.spring.model.Member
import com.callor.spring.service.MemberService
import org.springframework.stereotype.Service

@Service
class MemberServiceImpl : MemberService {
    companion object {
        val memberList = arrayOf(
            Member(
                "B001", "롯데상사", "02-222-9999", "서울시 영등포구", "홍길동", "010-9999-8766", 91000
            ),
            Member(
                "B002", "삼부상사", "062-526-9988", "광주 북구",
                "이몽룡", "010-9896-6781", 2900
            )
        )
    }

    override fun selectAll(): Array<Member> {
//        TODO("Not yet implemented")
        return memberList
    }

    override fun findById(m_id: String): Member {
//        TODO("Not yet implemented")
        return memberList[0]
    }
}