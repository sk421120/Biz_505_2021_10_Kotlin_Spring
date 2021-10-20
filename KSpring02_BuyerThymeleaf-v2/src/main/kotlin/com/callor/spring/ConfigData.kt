package com.callor.spring

import com.callor.spring.model.Buyer

class ConfigData {
    // public static final String APP_NAME = "나라상사 고객관리"
    //  System.out.println( ConfigString.APP_NAME )
    // java static 키워드와 유사한 역할을 하는 객체
    companion object {
        val APP_NAME = "나라상사 고객관리"
        val APP_VERSION = "2021 v2"
        //    val RND = Random(System.currentTimeMillis())
        val BUYER_LIST = arrayOf(
            Buyer(
                m_id = "B001", m_name = "롯데상사", m_tel = "02-222-9999",
                m_addr = "서울시 영등포구",m_man = "홍길동",
                m_manTel = "010-9999-8766",m_total =  91000
            ),
            Buyer(
                m_id = "B002", m_name = "롯데상사", m_tel = "02-222-9999",
                m_addr = "서울시 영등포구",m_man = "홍길동",
                m_manTel = "010-9999-8766",m_total =  91000
            ),
            Buyer(
                m_id = "B003", m_name = "롯데상사", m_tel = "02-222-9999",
                m_addr = "서울시 영등포구",m_man = "홍길동",
                m_manTel = "010-9999-8766",m_total =  91000
            )
        )
    }
}