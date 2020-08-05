package com.cheng.dao.impl;

import com.cheng.dao.IUserDao;
import com.cheng.pojo.Permission;
import com.cheng.pojo.Role;
import com.cheng.pojo.User;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl extends SqlSessionDaoSupport implements IUserDao {


    @Override
    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public User login(User user) {

        String password = user.getPassword();
        password = new Md5Hash(password,"wang").toString();
        user.setPassword(password);

        return getSqlSession().selectOne("com.cheng.pojo.UsersMapper.login",user);
    }

    @Override
    public List<Role> getRolesByUsername(String username) {
        return null;
    }

    @Override
    public List<Permission> getPermissionByUsername(String username) {
        return null;
    }
}
