package com.callor.spring.service.impl

import com.callor.spring.models.Sales
import com.callor.spring.repository.SalesRepository
import com.callor.spring.service.OrderService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service("orServiceV1")
class OrderServiceImplV1(val saleDao: SalesRepository) : OrderService {

    override fun selectAll(): Array<Sales> {
        return saleDao.findAll().toTypedArray()
    }

    override fun selectAll(pageable: Pageable): Page<Sales> {
        return saleDao.findAll(pageable)
    }

    override fun findById(seq: Long): Sales {
        return saleDao.findById(seq).get()
    }

    override fun findByUserId(userid: String): Array<Sales> {
        return saleDao.findByUserid(userid)
    }

    override fun findByPName(pname: String): Array<Sales> {
        return saleDao.findByPname(pname)
    }

    override fun findByDateDistance(sDate: String, eDate: String): Array<Sales> {
        TODO("Not yet implemented")
    }

    override fun insert(sales: Sales): Sales {
//        sales.total = sales.qty * sales.amt
        return saleDao.save(sales)
    }

    override fun delete(seq: Long) {
        saleDao.deleteById(seq)
    }

    override fun update(sales: Sales): Sales {
        return saleDao.save(sales)
    }

}