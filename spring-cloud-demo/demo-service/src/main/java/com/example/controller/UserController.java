package com.example.controller;

import com.example.service.UserService;
import com.example.model.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "根据用户id删除该用户信息",notes = "根据url的id来删除该用户信息")
    @ApiImplicitParam(name = "id",value = "用户id",required = true,dataType = "int",paramType = "path")
    @RequestMapping(method = RequestMethod.GET, value = "/delete/{id}")
    public void delete(@PathVariable("id") int id) {
        userService.delete(id);
    }

    @ApiOperation(value = "新增用户信息",notes = "新增用户信息")
    @ApiImplicitParam(name = "user",value = "用户详细实体user",required = true,dataType = "User")
    @RequestMapping(method = RequestMethod.POST, value = "/insert")
    public void insert(@RequestBody User user) {
        userService.insert(user);
    }

    @ApiOperation(value = "更新用户信息",notes = "更新用户信息")
    @ApiImplicitParam(name = "user",value = "用户详细实体user",required = true,dataType = "User")
    @RequestMapping(method = RequestMethod.POST, value = "/update")
    public void update(@RequestBody User user) {
        userService.update(user);
    }

    @ApiOperation(value = "根据用户id获取用户详细信息",notes = "根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id",value = "用户id",required = true,dataType = "int",paramType = "path")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}/select")
    public User select(@PathVariable("id") int id) {
        return userService.selectById(id);
    }

    @ApiOperation(value = "分页查询用户信息",notes = "分页查询用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum",value = "起始页",required = true,dataType = "Integer",paramType = "path"),
            @ApiImplicitParam(name = "pageSize",value = "页大小",required = true,dataType = "Integer",paramType = "path")})
    @RequestMapping(method = RequestMethod.GET, value = "/selectAll/{pageNum}/{pageSize}")
    public List<User> selectAll(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        return userService.selectAll(pageNum, pageSize);
    }
}
