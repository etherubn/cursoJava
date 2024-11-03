package com.curso.springboot.repository;

import com.curso.springboot.model.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICategoryRepo  extends IGenericRepo<Category,Long> {

    //************Derived Query**************
    //Solo para consultas de una misma tabla

    //SELEC * from Catecory c where c.name ='' ;
    List<Category> findByName(String name);
    //SELEC * from Catecory c where c.name Like '%abc%' ;
    List<Category> findByNameLike(String name);
    //%XYZ$ -> findByNameContains
    //%XYZ -> findbyNameStartsWith
    //XYZ% -> findByNameEndsWith

    //Tener 2 campos
    List<Category> findByNameAndEnabled(String name,boolean enabled);

    //Si queremos los que tengan enabled = true
    List<Category> findByEnabledTrue();

    //Buscar un elememento por nombre, retorna Optional
    Optional<Category> findOneByName(String name);

    //Tener las 3 primeras coincidencias
    List<Category> findTop3ByName(String name);

    //Nombres que no son
    List<Category> findByNameIsNot(String name);

    //Nombres que son nulos
    List<Category> findByNameIsNull();

    //Nombres que no son nulos
    List<Category> findByNameIsNotNull();

    //JPQL
    @Query("FROM Category c where c.name=:name AND c.description LIKE %:description%")
    List<Category> findByNameAndDescription(String name,String description);

    //Si quiero solo el campo nombre y enabled debo crear un constructor que tenga esos 2 en el model
    @Query("select new Category(c.name,c.enabled) FROM Category c where c.name=:name AND c.description LIKE %:description%")
    List<Category> findByNameAndDescription1(String name,String description);

    //Queries nativos es igual que en base de datos
}
