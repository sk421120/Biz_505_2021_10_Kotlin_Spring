package com.callor.readbook.service

import com.callor.readbook.models.MemberVO
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class MemberLoginService:UserDetailsService {

    // 가상의 MemberList 만들기
    val userList = listOf(
        MemberVO(username="callor", password = "1234"),
        MemberVO(username="callor88", password = "1234"),
        MemberVO(username="callorok", password = "1234"),
        MemberVO(username="hello", password = "12345")
    )

    override fun loadUserByUsername(username:String): UserDetails {
        val member:UserDetails? = userList.find {
            it.username == username
        }
        member ?: throw UsernameNotFoundException("Wrong User Id")
//        if(member == null) {
//        }

        return member
    }
}