package com.example.ooracle.mapper;

import com.example.ooracle.pojo.TOrder;
import com.example.ooracle.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TOrderMapper extends MyMapper<TOrder> {
    List<TOrder> selectByUserId(int userId);

    int insertOrder(@Param("user_id") int userId, @Param("num") int num, @Param("goods_id") int goodId);
}