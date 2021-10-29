package com.callor.readbook

import com.callor.readbook.config.logger
import com.callor.readbook.models.BookDTO
import com.callor.readbook.models.ReadBookDTO
import com.callor.readbook.models.ReadBookVO
import com.callor.readbook.repository.BookRepository
import com.callor.readbook.repository.ReadBookRepository
import com.callor.readbook.service.ReadBookService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
class ReadBookController// 생성자 주입으로 2개의 Repository 를 가져온다.
    (
    val readBookDao: ReadBookService
) {

    //    l..host:8080/readbook/
    @RequestMapping(value = ["", "/"], method = [RequestMethod.GET])
    fun home(): String {
        //    l..host:8080/readbook/insert
        return "redirect:/insert"
    }

    @RequestMapping(value = ["/insert"], method = [RequestMethod.GET])
    fun insert(): String {
        return "readbook/write"
    }

    //    l..host:8080/readbook/insert
    @RequestMapping(value = ["/insert"], method = [RequestMethod.POST])
    fun insert(readBook: ReadBookVO): String {

        logger().debug(
            """>
            수신한 데이터 {}
        """, readBook.toString()
        )

        readBookDao.readBookInsert(readBook)

        return "redirect:/insert"
    }
}