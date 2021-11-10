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
@RequestMapping(value = ["/read"])
class ReadBookController(val rbService : ReadBookService,
                         val bService : BookService) {

    @RequestMapping(value = ["/", ""], method = [RequestMethod.GET])
    fun list(model:Model):String {
        model["RBLIST"] =  rbService.selectAll()
        return "readBook/list"
    }

    @RequestMapping(value = ["/insert"], method = [RequestMethod.GET])
    fun insert(isbn:String, model:Model):String {
        if(isbn == null){
            model["BOOK"] = BookDTO(isbn="")
        } else {
            model["BOOK"] = bService.findByIsbn(isbn)
        }
        return "readBook/write"
    }

//    @ResponseBody
    @RequestMapping(value = ["/insert"], method = [RequestMethod.POST])
    fun insert(readBook: ReadBookVO):String {
        rbService.insert(readBook)
//        bService.insert(book)
        return "redirect:/read"
//        return rbService.selectAll().get(0)
    }
}