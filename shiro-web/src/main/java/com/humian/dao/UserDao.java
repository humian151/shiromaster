package com.humian.dao;

import com.humian.entity.User;
import com.humian.repository.DomainRepository;

/**
 * Created by DELL on 2018/7/20.
 */
public interface UserDao{

    User getUserByUsername(String username);
}
