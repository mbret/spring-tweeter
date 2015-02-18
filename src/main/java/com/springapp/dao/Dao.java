package com.springapp.dao;

import java.util.List;

public interface Dao<T> {
    
    public List<T> findAll();

    public T findOne(Object id);
    
    public void create(T object);
}
