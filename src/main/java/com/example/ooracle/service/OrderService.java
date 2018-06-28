package com.example.ooracle.service;

import com.example.ooracle.mapper.TGoodsMapper;
import com.example.ooracle.mapper.TOrderMapper;
import com.example.ooracle.mapper.TUserMapper;
import com.example.ooracle.pojo.LayUIOrder;
import com.example.ooracle.pojo.TGoods;
import com.example.ooracle.pojo.TOrder;
import com.example.ooracle.pojo.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private TOrderMapper orderMapper;

    @Autowired
    private TGoodsMapper goodsMapper;

    @Autowired
    private TUserMapper userMapper;

    public List<TOrder> selectAll() {
        return orderMapper.selectAll();
    }


    public List<LayUIOrder> selectLayuiAll() {
        ArrayList<LayUIOrder> layUIOrders = new ArrayList<>();
        List<TOrder> orderList = orderMapper.selectAll();
        for (TOrder order : orderList) {
            TUser user = userMapper.selectByPrimaryKey(order.getUserId());
            TGoods goods = goodsMapper.selectByPrimaryKey(order.getGoodsId());
            LayUIOrder layUIOrder = new LayUIOrder();
            layUIOrder.setId(order.getId());
            layUIOrder.setCreTime(order.getCretime());
            layUIOrder.setAddress(user.getAddress());
            layUIOrder.setGoodsName(goods.getName());
            layUIOrder.setUsername(user.getUsername());
            layUIOrder.setNum(order.getNum());
            layUIOrder.setMoney(goods.getPrice() * order.getNum());
            layUIOrders.add(layUIOrder);
        }
        return layUIOrders;
    }

    public List<LayUIOrder> selectByUsername(String username) {
        TUser user = userMapper.selectByUserName(username);
        ArrayList<LayUIOrder> layUIOrders = new ArrayList<>();
        List<TOrder> orderList = orderMapper.selectByUserId(user.getId());
        for (TOrder order : orderList) {
            TGoods goods = goodsMapper.selectByPrimaryKey(order.getGoodsId());
            LayUIOrder layUIOrder = new LayUIOrder();
            layUIOrder.setCreTime(order.getCretime());
            layUIOrder.setAddress(user.getAddress());
            layUIOrder.setGoodsName(goods.getName());
            layUIOrder.setNum(order.getNum());
            layUIOrder.setMoney(goods.getPrice() * order.getNum());
            layUIOrders.add(layUIOrder);
        }
        return layUIOrders;
    }

    public void insertOrder(int goodsId, int num, String username) {
        TUser user = userMapper.selectByUserName(username);
        orderMapper.insertOrder(user.getId(), num, goodsId);
    }
}
