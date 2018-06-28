package com.example.ooracle.controller;

import com.example.ooracle.pojo.TGoods;
import com.example.ooracle.service.GoodsService;
import com.example.ooracle.service.OrderService;
import com.example.ooracle.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BaseController {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/register")
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/user")
    public String user() {
        return "user";
    }

    @RequestMapping(value = "/goods")
    public String goods() {
        return "goods";
    }

    @RequestMapping(value = "shop")
    public ModelAndView shop() {
        ModelAndView mv = new ModelAndView("shop");
        List<TGoods> list = goodsService.selectAll();
        mv.addObject("goodsList",list);
        return mv;
    }

    @RequestMapping(value = "address")
    public ModelAndView address(){
        ModelAndView mv = new ModelAndView("address");
        return mv;
    }

    @RequestMapping(value = "order")
    public ModelAndView order(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        ModelAndView mv = new ModelAndView("order");
        mv.addObject("orderList",orderService.selectByUsername(userDetails.getUsername()));
        return mv;
    }

    @RequestMapping(value = "admin/order")
    public String adminOrder(){
        return "adminorder";
    }
}
