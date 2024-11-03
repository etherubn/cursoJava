package com.curso.springboot.repository;

import com.curso.springboot.model.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductRepo extends IGenericRepo<Product,Long >{

    //select * from Product p inner join Category c on p.idCategory = c.idCategory where c.name= ?

    @Query("FROM Product p where p.category.name = :name")
    List<Product> getProductsByCategory(String name);
}
