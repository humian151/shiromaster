package com.humian.repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by DELL on 2018/7/20.
 */
public interface DomainRepository<T,PK extends Serializable>{
    T load(PK id);

    List<T> findAll();

    void persist(T entity);

    PK save(T entity);

    void saveOrUpdate(T entity);

    void delete(PK id);

    void flush();
}
