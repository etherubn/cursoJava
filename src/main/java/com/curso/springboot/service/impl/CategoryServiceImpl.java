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
public class CategoryServiceImpl extends CRUDImpl<Category,Long> implements ICategoryService{

    private final ICategoryRepo categoryRepo;

    @Override
    protected IGenericRepo<Category, Long> getRepo() {
        return categoryRepo;
    }

    @Override
    public List<Category> findByName(String name) {
        return categoryRepo.findByName(name);
    }

    @Override
    public List<Category> findByNameAndEnabled(String name, boolean enabled) {
        return categoryRepo.findByNameAndEnabled(name,enabled);
    }

    @Override
    public List<Category> findByNameAndDescription(String name, String description) {
        return categoryRepo.findByNameAndDescription(name,description);
    }

    @Override
    public List<Category> findByNameAndDescription1(String name, String description) {
        return categoryRepo.findByNameAndDescription1(name,description);
    }
}
