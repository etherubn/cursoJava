package com.curso.springboot.service.impl;

import com.curso.springboot.model.Product;
import com.curso.springboot.repository.IGenericRepo;
import com.curso.springboot.repository.IProductRepo;
import com.curso.springboot.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl extends CRUDImpl<Product,Long> implements IProductService {

    private final IProductRepo iProductRepo;

    @Override
    protected IGenericRepo<Product, Long> getRepo() {
        return iProductRepo;
    }

    @Override
    public List<Product> getProductsByCategory(String name) {
        return iProductRepo.getProductsByCategory(name);
    }
}
