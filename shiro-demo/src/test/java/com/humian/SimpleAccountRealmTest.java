package com.humian;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by DELL on 2018/7/19.
 */
public class SimpleAccountRealmTest {
    SimpleAccountRealm realm;
    @Before
    public void createRealm(){
        realm = new SimpleAccountRealm();
        realm.addAccount("zs","123456","admin");

    }
    @Test
    public void test(){
        /*1.构建SecurityManager */
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        SecurityUtils.setSecurityManager(securityManager);
        securityManager.setRealm(realm);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("zs","123456");
        subject.login(token);
        subject.checkRole("admin");
    }
}
