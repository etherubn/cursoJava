package com.curso.springboot.service;

import com.curso.springboot.model.Category;

import java.util.List;


public interface ICategoryService extends ICRUD<Category,Long> {
    List<Category> findByName(String name);
    List<Category> findByNameAndEnabled(String name,boolean enabled);
    List<Category> findByNameAndDescription(String name,String description);
    List<Category> findByNameAndDescription1(String name,String description);
}
