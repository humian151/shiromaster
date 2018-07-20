package com.humian.repository.impl;

import com.humian.repository.DomainRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by DELL on 2018/7/20.
 */
@Repository
public class DomainRepositoryImpl<T,PK extends Serializable> implements DomainRepository<T,PK> {
    @Autowired
    SessionFactory sessionFactory;


    protected Class<T> entityClass;

    public Session getSession(){
        return sessionFactory.openSession();
    }

    @Override
    public T load(PK id) {
        return (T) getSession().load(entityClass,id);
    }

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public void persist(T entity) {
        getSession().persist(entity);
    }

    @Override
    public PK save(T entity) {
        return (PK) getSession().save(entity);
    }

    @Override
    public void saveOrUpdate(T entity) {
        getSession().saveOrUpdate(entity);
    }

    @Override
    public void delete(PK id) {
        getSession().delete(load(id));
    }

    @Override
    public void flush() {
        getSession().flush();
    }
}
