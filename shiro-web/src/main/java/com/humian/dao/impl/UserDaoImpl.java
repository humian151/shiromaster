package com.humian.dao.impl;

import com.humian.dao.UserDao;
import com.humian.entity.User;
import com.humian.repository.impl.DomainRepositoryImpl;
import org.apache.commons.collections.CollectionUtils;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl extends DomainRepositoryImpl<User,Integer> implements UserDao {
    @Autowired
    HibernateTemplate hibernateTemplate;

    @Override
    public User getUserByUsername(String username) {
        List<User> users = (List<User>) hibernateTemplate.find("from User where username=?", new String[]{username});
        if(CollectionUtils.isEmpty(users)){
            return null;
        }
        return users.get(0);
    }

}
