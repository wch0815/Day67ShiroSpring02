package com.cheng.dao;

import com.cheng.pojo.Permission;
import com.cheng.pojo.Role;
import com.cheng.pojo.User;

import java.util.List;

public interface IUserDao {
    User login(User user);

    List<Role> getRolesByUsername(String username);

    List<Permission> getPermissionByUsername(String username);
}
