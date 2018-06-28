package com.example.ooracle.service;


import com.example.ooracle.mapper.TUserMapper;
import com.example.ooracle.pojo.TUser;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.ArrayList;
import java.util.List;

public class CustomUserService implements UserDetailsService {

    @Autowired
    private TUserMapper userMapper;

    @Autowired
    private TUser user;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        user =  userMapper.selectByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        List<SimpleGrantedAuthority> authorities=new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()), authorities);
    }
}
