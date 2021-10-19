package com.callor.spring.service.impl

import com.callor.spring.model.Buyer
import com.callor.spring.service.BuyerService
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class BuyerServiceImpl : BuyerService {

    //    현재 BuyerServiceImplV1 에서 사용할 가상 데이터를 선언하기
//    private : 여기 클래스 내부에서만 사용하는 static 변수 선언하기
    companion object {
        val RND = Random(System.currentTimeMillis())

        val BUYER_LIST = arrayOf(
            Buyer(
                "B001", "롯데상사", "02-222-9999", "서울시 영등포구",
                "홍길동", "010-9999-8766", 91000
            ),
            Buyer(
                "B002", "삼부상사", "062-526-9988", "광주 북구",
                "이몽룡", "010-9896-6781", 2900
            ),
            Buyer(
                "B003", "코기상사", "062-123-4567", "광주 동구",
                "코기이", "010-4567-7890", 3000
            )
        )
    }

    override fun findByName(m_name: String): Array<Buyer> {

        val userNum = RND.nextInt(BUYER_LIST.size)
        return arrayOf(BUYER_LIST[userNum])
    }

    override fun findByTel(m_tel: String): Array<Buyer> {
        TODO("Not yet implemented")
    }

    override fun insert(buyer: Buyer): Int {
        TODO("Not yet implemented")
    }

    override fun delete(m_id: String): Int {
        TODO("Not yet implemented")
    }

    override fun update(buyer: Buyer): Int {
        TODO("Not yet implemented")
    }

    override fun selectAll(): Array<Buyer> {
//        TODO("Not yet implemented")
        return BUYER_LIST
    }

    override fun findById(m_id: String): Buyer {
//        TODO("Not yet implemented")
        val findUser = BUYER_LIST.filter { buyer -> buyer.m_id == m_id  }
        return findUser[0]
    }
}