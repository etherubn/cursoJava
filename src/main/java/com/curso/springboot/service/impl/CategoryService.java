package com.curso.springboot.service.impl;

import com.curso.springboot.model.Category;
import com.curso.springboot.repository.ICategoryRepo;
import com.curso.springboot.repository.IGenericRepo;
import com.curso.springboot.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryService extends CRUDImpl<Category,Long> implements ICategoryService{

    private final ICategoryRepo categoryRepo;

    @Override
    protected IGenericRepo<Category, Long> getRepo() {
        return categoryRepo;
    }
}
