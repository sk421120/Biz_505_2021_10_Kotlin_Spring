package com.callor.spring.repository

import com.callor.spring.models.Sales
import org.springframework.data.jpa.repository.JpaRepository

// Repository 인터페이스 생성
// JpaRepository 를 상속받고 데이터를 DTO 와 테이블의 PK 값을 Generic 으로 설정해 준다
interface SalesRepository:JpaRepository<Sales, Long> {

    fun findByPname(pname:String):Array<Sales>
    fun findByUserid(userid:String):Array<Sales>
}