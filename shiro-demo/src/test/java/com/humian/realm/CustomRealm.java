package com.humian.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by DELL on 2018/7/19.
 */
public class CustomRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) getAvailablePrincipal(principals);
        Set<String> roleNames = new HashSet<>();
        roleNames.add("admin");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String username = upToken.getUsername();
        String password = "";
        if("zs".equals(username)){
            password="aaa";
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password, getName());
        return info;
    }
}
