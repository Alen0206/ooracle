package com.example.ooracle;


import com.example.ooracle.mapper.TGoodsMapper;
import com.example.ooracle.mapper.TOrderMapper;
import com.example.ooracle.mapper.TUserMapper;
import com.example.ooracle.pojo.LayUIOrder;
import com.example.ooracle.pojo.TGoods;
import com.example.ooracle.pojo.TOrder;
import com.example.ooracle.pojo.TUser;
import com.example.ooracle.service.OrderService;
import com.example.ooracle.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = OoracleApplication.class)
@EnableAutoConfiguration
public class OoracleApplicationTests{

    @Autowired
    private UserService userService;

    @Autowired
    private TUserMapper userMapper;

    @Autowired
    private TGoodsMapper goodsMapper;

    @Autowired
    private TOrderMapper orderMapper;

    @Autowired
    private OrderService orderService;

    @Test
    public void userMapperTest() {

     List<TUser> orderList = userMapper.selectAll();
     for (TUser order:orderList){
         System.out.println(order.toString());
     }

    }


}
