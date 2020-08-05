package com.cheng.shiro;

import com.cheng.pojo.Permission;
import com.cheng.pojo.Role;
import com.cheng.pojo.User;
import com.cheng.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        String username = getAvailablePrincipal(principals).toString();

        List<Role> roles = userService.getRolesByUsername(username);

        for (Role r : roles) {
            info.addRole(r.getRname());
        }

        List<Permission> perms = userService.getPermissionByUsername(username);

        for(Permission p : perms){
            info.addStringPermission(p.getPname());
        }

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        AuthenticationInfo info = null;

        UsernamePasswordToken upt = (UsernamePasswordToken) token;

        String username = upt.getUsername();
        char[] password = upt.getPassword();
        String pass = new String(password);

        User user = new User();

        user.setUsername(username);
        user.setPassword(pass);
        User user1 = userService.login(user);
        if (user1!=null && user1.getUid()!=0){
            info = new SimpleAuthenticationInfo(username,pass,getName());
        }

        return info;
    }
}
