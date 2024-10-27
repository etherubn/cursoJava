package com.curso.springboot.repository;

import com.curso.springboot.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepo  extends IGenericRepo<Category,Long> {
}
