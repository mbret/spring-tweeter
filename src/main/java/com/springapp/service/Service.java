package com.springapp.service;

import com.springapp.domain.exception.ExistException;
import com.springapp.domain.model.Tweet;

import java.util.List;

public abstract interface Service<T> {

    public T findOne(Object id);
    
    public void create(T object);
    
    public List<T> findAll();
}