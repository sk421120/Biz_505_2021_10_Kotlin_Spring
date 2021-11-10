package com.callor.readbook.service

import com.callor.readbook.model.MemberVO
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class MemberLoginService:UserDetailsService {

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

        return member
    }
}