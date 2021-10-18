package com.callor.spring.controller

import com.callor.spring.service.MemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
class HomController {
//    @ResponseBody
//    @RequestMapping(value = ["/"], method = [RequestMethod.GET])
//    fun home():String {
//        return "우리나라만세"
//    }
    @Autowired
    private lateinit var mService: MemberService

    @RequestMapping(value = ["/"], method = [RequestMethod.GET])
    fun home(model:Model):String {
        var memberList = mService.selectAll()
//        var memberList = mService.findById("0")
        model.addAttribute("member", memberList)
        return "home"
    }
}