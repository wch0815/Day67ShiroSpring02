package com.cheng.service.impl;

import com.cheng.dao.IUserDao;
import com.cheng.pojo.Permission;
import com.cheng.pojo.Role;
import com.cheng.pojo.User;
import com.cheng.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public User login(User user) {
        return userDao.login(user);
    }

    @Override
    public List<Role> getRolesByUsername(String username) {
        return userDao.getRolesByUsername(username);
    }

    @Override
    public List<Permission> getPermissionByUsername(String username) {
        return userDao.getPermissionByUsername(username);
    }
}
