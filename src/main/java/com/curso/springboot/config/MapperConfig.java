package com.curso.springboot.config;

import com.curso.springboot.dto.CategoryDto;
import com.curso.springboot.model.Category;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean("defaultMapper")
    public ModelMapper defaultMapper(){
        return new ModelMapper();
    }

    @Bean("categoryMapper")
    public ModelMapper categoryMapper(){
        ModelMapper mapper = new ModelMapper();

        //Lectura
        mapper.createTypeMap(Category.class, CategoryDto.class)
                .addMapping(e-> e.getName(),(dest,v)-> dest.setNameofCategory((String) v));

        //Escritura
        mapper.createTypeMap(CategoryDto.class, Category.class)
                .addMapping(e->e.getNameofCategory(),(dest,v)->dest.setName((String) v));

        return mapper;

    }
}
