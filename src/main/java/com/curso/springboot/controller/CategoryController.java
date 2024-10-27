package com.curso.springboot.controller;

import com.curso.springboot.dto.CategoryDto;
import com.curso.springboot.model.Category;
import com.curso.springboot.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final ICategoryService categoryService;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> finAll(){
        List<CategoryDto> categoryDtos = categoryService.findAll().stream().map(
                category -> toDto(category)
        ).toList();

        return new ResponseEntity<>(categoryDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> findById(@PathVariable("id") Long id){
        Category category = categoryService.findById(id);

        return new ResponseEntity<>(toDto(category),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategoryDto> save(@RequestBody CategoryDto  categoryDto){
        Category category = categoryService.save(toEntity(categoryDto));

        return new ResponseEntity<>(toDto(category),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> save(Long id){
        categoryService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> update(Long id,@RequestBody CategoryDto categoryDto) throws Exception {
        Category category = categoryService.update(id,toEntity(categoryDto));

        return new ResponseEntity<>(toDto(category),HttpStatus.OK);
    }

    private  CategoryDto toDto(Category category){
        return modelMapper.map(category, CategoryDto.class);
    }

    private Category toEntity(CategoryDto categoryDto){
        return modelMapper.map(categoryDto, Category.class);
    }
}

