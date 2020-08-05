package com.cheng.service;

import com.cheng.pojo.Permission;
import com.cheng.pojo.Role;
import com.cheng.pojo.User;

import java.util.List;

public interface IUserService {
    User login(User user);

    List<Role> getRolesByUsername(String username);

    List<Permission> getPermissionByUsername(String username);
}
