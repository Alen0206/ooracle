package com.example.ooracle.service;

import com.example.ooracle.mapper.TGoodsMapper;
import com.example.ooracle.pojo.TGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {
    @Autowired
    private TGoodsMapper goodsMapper;


    public List<TGoods> selectAll(){
        return goodsMapper.selectAll();
    }
}
