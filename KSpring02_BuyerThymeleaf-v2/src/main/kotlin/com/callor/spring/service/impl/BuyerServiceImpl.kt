package com.callor.spring.service.impl

import com.callor.spring.ConfigData
import com.callor.spring.model.Buyer
import com.callor.spring.repository.BuyerRepository
import com.callor.spring.service.BuyerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.random.Random

/**
 * 클래스의 매개변후를 사용하여 생성자 주입하기
 *
 * class 클래스( 주입받을 객체, 변수 선언 )
 */
@Service("bServiceV1")
class BuyerServiceImpl(val bRepo: BuyerRepository) : BuyerService {

    // setter 주입으로 wiring하기
    @Autowired
    lateinit var bDao: BuyerRepository

    val RND = Random(System.currentTimeMillis())
    //    현재 BuyerServiceImplV1 에서 사용할 가상 데이터를 선언하기
//    private : 여기 클래스 내부에서만 사용하는 static 변수 선언하기

    override fun selectAll(): Array<Buyer> {
        return ConfigData.BUYER_LIST
    }

    override fun findById(m_id: String): Buyer {
//        TODO("Not yet implemented")
//        val findUser = ConfigData.BUYER_LIST.filter
//        return findUser[0]
        return ConfigData.BUYER_LIST[0]
    }

    override fun findByName(m_name: String): Array<Buyer> {

        val userNum = RND.nextInt(ConfigData.BUYER_LIST.size)
        return arrayOf(ConfigData.BUYER_LIST[userNum])
    }

    override fun findByTel(m_tel: String): Array<Buyer> {
//        TODO("Not yet implemented")
        return ConfigData.BUYER_LIST
    }

    override fun insert(buyer: Buyer): Buyer {
        val resultBuyer = bDao.save(buyer)
        return resultBuyer
//        return 0
    }

    override fun delete(m_id: String): Buyer {
//        TODO("Not yet implemented")
        return ConfigData.BUYER_LIST[0]
    }

    override fun update(buyer: Buyer): Buyer {
//        TODO("Not yet implemented")
        return ConfigData.BUYER_LIST[0]
    }


}