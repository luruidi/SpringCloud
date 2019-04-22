package com.example.service.impl;

import com.example.service.UserService;
import com.example.model.User;
import com.example.mapper.UserMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 删除 * * @param id
     */
    @Override
    public void delete(int id) {
        userMapper.deleteByPrimaryKey(id);
    }

    /**
     * 增加 * * @param user
     */
    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }

    /**
     * 更新 * * @param user
     */
    @Override
    public int update(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    /**
     * 查询单个 * * @param id
     */
    @Override
    public User selectById(int id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    /**
     * 查询全部列表,并做分页 * * @param pageNum 开始页数 * @param pageSize 每页显示的数据条数
     */
    @Override
    public List<User> selectAll(int pageNum, int pageSize) {
        //使用PageHelper实现分页
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = userMapper.selectAll();
        return list;
        //PageInfo<User> pageInfo = new PageInfo<>(list);
        //return pageInfo.getList();
    }
}

