package com.callor.spring.service.impl

import com.callor.spring.model.Product
import com.callor.spring.service.ProductService
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class ProductServiceImplV1 : ProductService {

    companion object {
        val RND = Random(System.currentTimeMillis())

        val PRODUCT_LIST = arrayOf(
            Product(
                "P001", "B003", "카페라떼는", 2000, 20
            ),
            Product(
                "P002", "B003", "두유라떼는", 1000, 5
            ),
            Product(
                "P003", "B003", "모카라떼는", 1500, 10
            )
        )
    }

    override fun selectAll(): Array<Product> {
        return PRODUCT_LIST
    }

    override fun findById(p_id: String): Product {
        TODO("Not yet implemented")
    }

    override fun findByName(p_name: String): Array<Product> {
        TODO("Not yet implemented")
    }

    override fun findByBuyer(p_mId: String): List<Product> {
        val findProduct = PRODUCT_LIST.filter { product -> product.p_mId == p_mId }
        return findProduct
    }

    override fun totalPriceByBuyer(p_mId: String): Array<Int> {
        val findProduct = findByBuyer(p_mId)
        var sum_price = 0
        var sum_qty = 0

        findProduct.forEach {
            sum_price = sum_price + it.p_price
            sum_qty = sum_qty + it.p_qty
        }

        var sum_total = sum_price + sum_qty
        return arrayOf(sum_price, sum_qty, sum_total)
    }

    override fun insert(product: Product): Int {
        TODO("Not yet implemented")
    }

    override fun delete(p_id: String): Int {
        TODO("Not yet implemented")
    }

    override fun update(product: Product): Int {
        TODO("Not yet implemented")
    }
}