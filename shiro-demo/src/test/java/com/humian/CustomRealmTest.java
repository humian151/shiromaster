package com.humian;

import com.humian.realm.CustomRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * Created by DELL on 2018/7/19.
 */
public class CustomRealmTest {
    @Test
    public void test(){
        CustomRealm realm = new CustomRealm();
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setRealm(realm);
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zs","aaa");
        subject.login(token);
        subject.checkRole("admin");
    }
}
