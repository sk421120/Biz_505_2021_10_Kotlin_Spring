package com.callor.readbook.controller

import com.callor.readbook.model.BookDTO
import com.callor.readbook.model.BookVO
import com.callor.readbook.model.ReadBookDTO
import com.callor.readbook.model.ReadBookVO
import com.callor.readbook.service.BookService
import com.callor.readbook.service.ReadBookService
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping(value = ["/read"])
class ReadBookController(val rbService : ReadBookService,
                         val bService : BookService) {

    @RequestMapping(value = ["/", ""], method = [RequestMethod.GET])
    fun list(model:Model):String {
        model["RBLIST"] =  rbService.selectAll()
        return "readBook/list"
    }

//    @ResponseBody
//    @RequestMapping(value = ["/insert/{isbn}"], method = [RequestMethod.GET])
//    fun insertByBook(@PathVariable("isbn") isbn: String, model: Model):String {
//        model["BOOK"] = bService.findByIsbn(isbn)
////        return bService.findByIsbn(isbn).toString()
//        return "readBook/write"
//    }

    @RequestMapping(value = ["/insert"], method = [RequestMethod.GET])
    fun insert(model:Model):String {
        model["BOOK"] = BookVO("","","","",0)
        return "readBook/write"
    }

    @RequestMapping(value = ["/list/{isbn}"], method = [RequestMethod.GET])
    fun list(@PathVariable("isbn") isbn: String, model:Model):String {
        model["RBLIST"] =  rbService.findByIsbn(isbn)
        return "readBook/list"
    }

//    @ResponseBody
    @RequestMapping(value = ["/insert"], method = [RequestMethod.POST])
    fun insert(readBook: ReadBookVO):String {
        rbService.insert(readBook)
//        bService.insert(book)
        return "redirect:/"
//        return rbService.selectAll().get(0)
    }
}