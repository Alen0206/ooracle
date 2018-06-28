package com.example.ooracle.api;

import com.example.ooracle.pojo.TUser;
import com.example.ooracle.service.UserService;
import com.example.ooracle.util.ApiResponse;
import com.example.ooracle.util.Layui;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserApi {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/user/{id}")
    public ApiResponse selectById(@PathVariable("id") int id) {
        return ApiResponse.success(userService.selectById(id));
    }

    @DeleteMapping(value = "/user/{id}")
    public ApiResponse deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return ApiResponse.success("删除成功", null);
    }

    @PostMapping("/user/check")
    public ApiResponse checkUserName(@RequestParam("username") String userName) {
        if (userService.checkUserName(userName) == true) {
            return ApiResponse.success("用户名可用", null);
        } else {
            return ApiResponse.failure("用户名已存在", null);
        }

    }

    /**
     * Layui分页
     *
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/users")
    public Layui selectAll(@RequestParam(value = "page") int page, @RequestParam(value = "limit") int limit) {

        PageHelper.startPage(page, limit);
        List<TUser> userList = userService.selectAll();
        PageInfo pageInfo = new PageInfo(userList);
        if (userList == null) {
            return Layui.data(0, null);
        } else {
            return Layui.data((int) pageInfo.getTotal(), pageInfo.getList());
        }

    }

    @GetMapping(value = "/user/search")
    public Layui search(@RequestParam(value = "page") int page,
                        @RequestParam(value = "limit") int limit, @RequestParam(value = "username") String username) {
        List<TUser> users = userService.searchUser(username);
        PageHelper.startPage(page, limit);
        PageInfo pageInfo = new PageInfo(users);
        return Layui.data((int) pageInfo.getTotal(), pageInfo.getList());
    }


    @GetMapping(value = "/user")
    public ApiResponse selectAll() {
        return ApiResponse.success(userService.selectAll());
    }

    @PutMapping(value = "/user")
    public ApiResponse updateUser(TUser user) {
        userService.updateUser(user);
        return ApiResponse.success("修改成功", null);
    }

    @PostMapping(value = "/user")
    public ApiResponse insertUser(TUser user) {
        userService.insertUser(user);
        return ApiResponse.success("添加成功", false);
    }

}
