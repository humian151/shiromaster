package com.humian.realm;

import com.humian.dao.UserDao;
import com.humian.entity.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by DELL on 2018/7/19.
 */
public class CustomRealm extends AuthorizingRealm {
    @Autowired
    private UserDao userDao;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) getAvailablePrincipal(principals);
        Set<String> roleNames = new HashSet<>();
        roleNames.add("admin");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);
        return info;
    }

    /* 用户认证 */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String username = upToken.getUsername();

        User user = userDao.getUserByUsername(username);

        if(user ==null){
            return null;
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, user.getPassword(), getName());
        return info;
    }
}
