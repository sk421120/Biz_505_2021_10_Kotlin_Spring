package com.callor.spring.controller

import com.callor.spring.ConfigData
import com.callor.spring.model.Buyer
import com.callor.spring.service.BuyerService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping(value = ["/buyer"])
class BuyerController(val bService:BuyerService) {

    @RequestMapping(value = ["/"], method = [RequestMethod.GET])
    fun list(model:Model):String {
        val buyerList = bService.selectAll()
        model["BUYERS"] = buyerList

        return "home"
    }

    /**
     * @ResponseBody
     * 문자열, 객체, 배열 등등의 모든 데이터를 있는 그대로 또는 JSON 형태로 변환하여 client에 보내라
     */
    @ResponseBody
    @RequestMapping(value = ["/list"], method = [RequestMethod.GET])
    fun list(): Array<Buyer> {
        return bService.selectAll()
    }

    @RequestMapping(value = ["/detail"], method = [RequestMethod.GET])
    fun detail(model: Model, @RequestParam("m_id") m_id: String): String {
        var userInfo = bService.findById(m_id)
        model["USERINFO"] = userInfo

//        var proInfo = pService.selectAll()
//        model["PRODUCT"] = proInfo

        return "detail"
    }

    @ResponseBody
    @RequestMapping(value = ["/insert"], method = [RequestMethod.GET])
    fun insert(): Buyer {

        val insertBuyer = ConfigData.BUYER_LIST[0]
        bService.insert(insertBuyer)

        return insertBuyer
    }
}