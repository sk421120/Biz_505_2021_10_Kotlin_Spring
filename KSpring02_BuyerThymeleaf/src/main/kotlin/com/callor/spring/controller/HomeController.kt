package com.callor.spring.controller

import com.callor.spring.service.MemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
class HomeController {
    //    @ResponseBody
//    @RequestMapping(value = ["/"], method = [RequestMethod.GET])
//    fun home():String {
//        return "우리나라만세"
//    }
    @Autowired
    private lateinit var mService: MemberService

    /*
    Spring 일반 Controller 에서 method가 문자열을 return 하면 view 파일을 열어서
    rendering 하여 client 로 보내라

    REST API 방식
   RestController 또는 method에 @ResponseBody 가 부착되면
    문자열을 그대로 client 로 보내라
     */
    @RequestMapping(value = ["/"], method = [RequestMethod.GET])
    fun home(model: Model): String {
        var memberList = mService.selectAll()
//        var memberList = mService.findById("0")
        model.addAttribute("member", memberList)
        return "home"
    }
}