package com.callor.readbook.controller

import com.callor.readbook.model.BookDTO
import com.callor.readbook.model.ReadBookDTO
import com.callor.readbook.model.ReadBookVO
import com.callor.readbook.service.BookService
import com.callor.readbook.service.ReadBookService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
@RequestMapping(value = ["/book"])
class BookController(val rbService : ReadBookService,
                     val bService : BookService) {

    @RequestMapping(value = ["/", ""], method = [RequestMethod.GET])
    fun list(model:Model):String {
        model["BLIST"] =  bService.selectAll()
        return "book/list"
    }

    @RequestMapping(value = ["/insert"], method = [RequestMethod.GET])
    fun insert(model:Model):String {
        return "readBook/write"
    }

//    @ResponseBody
    @RequestMapping(value = ["/insert"], method = [RequestMethod.POST])
    fun insert(readBook: ReadBookVO):String {
        rbService.insert(readBook)
//        bService.insert(book)
        return "redirect:/book"
//        return rbService.selectAll().get(0)
    }
}