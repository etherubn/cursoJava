package com.curso.springboot.service;

import com.curso.springboot.model.Category;

import java.util.List;

public interface ICRUD<T,ID> {
    T save(T t);
    T update(ID id,T t) throws Exception;
    List<T> findAll();
    void delete(ID id);
    T findById(ID id);
}
