package com.example.ooracle.api;

import com.example.ooracle.pojo.TGoods;
import com.example.ooracle.pojo.TUser;
import com.example.ooracle.service.GoodsService;
import com.example.ooracle.util.ApiResponse;
import com.example.ooracle.util.Layui;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class GoodsApi {


    @Autowired
    private GoodsService goodsService;

    @GetMapping(value = "/goods")
    public ApiResponse selectAll(){
        return ApiResponse.success(goodsService.selectAll());
    }

    @GetMapping("/good")
    public Layui selectAll(@RequestParam(value = "page") int page, @RequestParam(value = "limit") int limit) {

        PageHelper.startPage(page, limit);
        List<TGoods> goodsList = goodsService.selectAll();
        PageInfo pageInfo = new PageInfo(goodsList);
        if (goodsList == null) {
            return Layui.data(0, null);
        } else {
            return Layui.data((int) pageInfo.getTotal(), pageInfo.getList());
        }

    }

}
