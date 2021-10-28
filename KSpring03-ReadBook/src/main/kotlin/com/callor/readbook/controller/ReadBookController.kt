package com.callor.readbook.controller

import com.callor.readbook.model.Book
import com.callor.readbook.model.ReadBook
import com.callor.readbook.service.BookService
import com.callor.readbook.service.ReadBookService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping(value = ["/read"])
class ReadBookController(val rbService : ReadBookService,
                         val bService : BookService) {

    @RequestMapping(value = ["/insert"], method = [RequestMethod.GET])
    fun insert(model:Model):String {
        return "readBook/write"
    }

//    @ResponseBody
    @RequestMapping(value = ["/insert"], method = [RequestMethod.POST])
    fun insert(readBook:ReadBook, book:Book):String {
        rbService.insert(readBook)
        bService.insert(book)
        return "redirect:/"
//        return rbService.selectAll().get(0)
    }
}