package com.curso.springboot.controller;

import com.curso.springboot.dto.CategoryDto;
import com.curso.springboot.model.Category;
import com.curso.springboot.service.ICategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final ICategoryService categoryService;
    @Qualifier("categoryMapper")
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
    public ResponseEntity<CategoryDto> save(@Valid @RequestBody CategoryDto  categoryDto){
        Category category = categoryService.save(toEntity(categoryDto));

        return new ResponseEntity<>(toDto(category),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> save(Long id){
        categoryService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> update(@PathVariable Long id,@Valid @RequestBody CategoryDto categoryDto) throws Exception {
        categoryDto.setIdCategory(id);
        Category category = categoryService.update(id,toEntity(categoryDto));

        return new ResponseEntity<>(toDto(category),HttpStatus.OK);
    }

    @GetMapping("find/name/{name}")
    public ResponseEntity<List<CategoryDto>> getByName(@PathVariable String name){
        List<CategoryDto> categoryDtos = categoryService.findByName(name).stream()
                .map(category -> toDto(category))
                .toList();

        return new ResponseEntity<>(categoryDtos,HttpStatus.OK);
    }

    @GetMapping("find/name/enabled")
    public ResponseEntity<List<CategoryDto>> getByName(@RequestParam String name,@RequestParam boolean enabled){
        List<CategoryDto> categoryDtos = categoryService.findByNameAndEnabled(name,enabled).stream()
                .map(category -> toDto(category))
                .toList();

        return new ResponseEntity<>(categoryDtos,HttpStatus.OK);
    }

    @GetMapping("find/name/desc")
    public ResponseEntity<List<CategoryDto>> getByNameAndDescription(@RequestParam String name,@RequestParam String description){
        List<CategoryDto> categoryDtos = categoryService.findByNameAndDescription(name,description).stream()
                .map(category -> toDto(category))
                .toList();

        return new ResponseEntity<>(categoryDtos,HttpStatus.OK);
    }

    @GetMapping("find/name/desc1")
    public ResponseEntity<List<CategoryDto>> getByNameAndDescription1(@RequestParam String name,@RequestParam String description){
        List<CategoryDto> categoryDtos = categoryService.findByNameAndDescription1(name,description).stream()
                .map(category -> toDto(category))
                .toList();

        return new ResponseEntity<>(categoryDtos,HttpStatus.OK);
    }

    private  CategoryDto toDto(Category category){
        return modelMapper.map(category, CategoryDto.class);
    }

    private Category toEntity(CategoryDto categoryDto){
        return modelMapper.map(categoryDto, Category.class);
    }
}

