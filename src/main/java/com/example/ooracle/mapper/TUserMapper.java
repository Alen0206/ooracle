package com.example.ooracle.mapper;

import com.example.ooracle.pojo.TUser;
import com.example.ooracle.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TUserMapper extends MyMapper<TUser> {
    TUser selectByUserName(String userName);

    List<TUser> selectAllUser();

    List<TUser> searchUser(String userName);

    int updateUser(@Param("id") int id, @Param("username") String userName,
                   @Param("password") String password, @Param("address") String address, @Param("phone") String phone);

    int insertUser(TUser user);
}