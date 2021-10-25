package com.callor.spring.controller

import com.callor.spring.models.Buyer
import com.callor.spring.models.Sales
import com.callor.spring.service.OrderService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.mvc.support.RedirectAttributes

@Controller
@RequestMapping(value = ["/order"])
class OrderController(val orService: OrderService) {

    // localhost:8080/order/
    // localhost:8080/order
    @RequestMapping(value = ["/", ""], method = [RequestMethod.GET])
    fun list(model: Model): String {
        val salesList = orService.selectAll()
        model["SALES"] = salesList
        return "/order/list"
    }

    @RequestMapping(value = ["/detail"], method = [RequestMethod.GET])
    fun detail(model: Model, @RequestParam("seq") seq: Long): String {
        val sale = orService.findById(seq)
        model["ORDER"] = sale
        return "/order/detail" // detail.html 을 열어라

    }

    @RequestMapping(value = ["/insert"], method = [RequestMethod.GET])
    fun insert(model: Model): String {
        // val insertBuyer = ConfigData.BUYER_LIST[0]
        model["ORDER"] = Sales()
        return "order/write"
    }

    @RequestMapping(value = ["/insert"], method = [RequestMethod.POST])
    fun insert(model: Model, sales: Sales): String {
        var amt: Int? = sales.amt
        var qty: Int? = sales.qty
        var total: Int? = amt?.times(qty!!)
        sales.total = total
//        sales.total = sales.qty * sales.amt
        orService.insert(sales)
        return "redirect:/order"
    }

    @RequestMapping(value = ["/update/{seq}"], method = [RequestMethod.GET])
    fun update(model: Model, @PathVariable("seq") seq: Long): String {
        val order = orService.findById(seq)
        model["ORDER"] = order
        return "order/write"
    }

    @RequestMapping(value = ["/update/{seq}"], method = [RequestMethod.POST])
    fun update(redirectAttributes: RedirectAttributes, sales: Sales, @PathVariable("seq") seq: Long): String {
        orService.update(sales)
        redirectAttributes["seq"] = sales.seq.toString()
        return "redirect:/order/detail"
    }

    @RequestMapping(value = ["/delete/{seq}"], method = [RequestMethod.GET])
    fun delete(@PathVariable("seq") seq: Long): String {
        orService.delete(seq)
        return "redirect:/order"
    }
}