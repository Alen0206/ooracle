package com.example.ooracle.service;

import com.example.ooracle.mapper.TUserMapper;
import com.example.ooracle.pojo.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private TUserMapper userMapper;

    public TUser selectById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public TUser selectByUserName(String UserName){
        return  userMapper.selectByUserName(UserName);
    }

    public List<TUser> selectAll(){
        return userMapper.selectAllUser();
    }

    public List<TUser> searchUser(String userName){
        return userMapper.searchUser(userName);
    }

    /**
     * true表示用户名可用
     * @param userName
     * @return
     */
    public boolean checkUserName(String userName) {
        TUser user = userMapper.selectByUserName(userName);
        if (user == null){
            return true;
        }
        return false;
    }

    public void deleteUser(int id){
        userMapper.deleteByPrimaryKey(id);
    }

    public void updateUser(TUser user){
        int id= user.getId();
        String userName = user.getUsername();
        String password = user.getPassword();
        String address = user.getAddress();
        String phone = user.getPhone();
        userMapper.updateUser(id,userName,password,address,phone);
    }

    public void insertUser(TUser user){
        userMapper.insertUser(user);
    }

}
