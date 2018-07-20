package com.humian;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by DELL on 2018/7/19.
 */
public class IniRealmTest {
    private final Logger logger = LoggerFactory.getLogger(IniRealmTest.class);
    @Test
    public void test(){
        IniRealm realm = new IniRealm("classpath:user.ini");
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setRealm(realm);
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("root","1234");
        subject.login(token);
        logger.info(String.valueOf(subject.hasRole("admin")));
        subject.checkPermission("aa");

    }
}
