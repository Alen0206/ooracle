package com.example.ooracle.api;

import com.example.ooracle.pojo.LayUIOrder;
import com.example.ooracle.pojo.TOrder;
import com.example.ooracle.pojo.TUser;
import com.example.ooracle.service.OrderService;
import com.example.ooracle.service.UserService;
import com.example.ooracle.util.ApiResponse;
import com.example.ooracle.util.Layui;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api")
public class OrderApi {
    @Autowired
    private OrderService orderService;


    /**
     * Layui分页
     *
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/orders")
    public Layui selectAll(@RequestParam(value = "page") int page, @RequestParam(value = "limit") int limit) {

        PageHelper.startPage(page, limit);
        List<LayUIOrder> orderList = orderService.selectLayuiAll();
        PageInfo pageInfo = new PageInfo(orderList);
        if (orderList == null) {
            return Layui.data(0, null);
        } else {
            return Layui.data((int) pageInfo.getTotal(), pageInfo.getList());
        }

    }

    @PostMapping("/order")
    public ApiResponse insertOrder(@RequestParam("username") String username, @RequestParam("num") int num, @RequestParam("goodsId") int goodsId) {
        orderService.insertOrder(goodsId, num, username);
        return ApiResponse.success();
    }


}
