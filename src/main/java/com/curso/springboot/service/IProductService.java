package com.curso.springboot.service;


import com.curso.springboot.model.Product;

import java.util.List;


public interface IProductService extends ICRUD<Product,Long> {
    List<Product> getProductsByCategory(String name);
}
