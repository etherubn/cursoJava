package com.curso.springboot.controller;

import com.curso.springboot.dto.ProductDto;
import com.curso.springboot.model.Product;
import com.curso.springboot.service.IProductService;
import com.curso.springboot.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {
    private final IProductService productService;
//    @Qualifier("defaultMapper")
//    private final ModelMapper modelMapper;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<ProductDto>> finAll(){
        List<ProductDto> productDtos = mapperUtil.mapList(productService.findAll(),ProductDto.class);

        return new ResponseEntity<>(productDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> findById(@PathVariable("id") Long id){
        Product product = productService.findById(id);

        return new ResponseEntity<>(mapperUtil.map(product,ProductDto.class),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductDto> save(@Valid @RequestBody ProductDto  productDto){
        Product product = productService.save(mapperUtil.map(productDto,Product.class));

        return new ResponseEntity<>(mapperUtil.map(product,ProductDto.class),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> save(Long id){
        productService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> update(@PathVariable Long id,@Valid @RequestBody ProductDto productDto) throws Exception {
        productDto.setIdProduct(id);
        Product product = productService.update(id,mapperUtil.map(productDto,Product.class));

        return new ResponseEntity<>(mapperUtil.map(product,ProductDto.class),HttpStatus.OK);
    }

    @GetMapping("/bycategory/{name}")
    public ResponseEntity<List<ProductDto>> findProductsByCategory(@PathVariable String name){
        List<ProductDto> productDtos = mapperUtil.mapList(productService.getProductsByCategory(name), ProductDto.class);

        return new ResponseEntity<>(productDtos,HttpStatus.OK);
    }

//    private  ProductDto toDto(Product product){
//        return modelMapper.map(product, ProductDto.class);
//    }
//
//    private Product toEntity(ProductDto productDto){
//        return modelMapper.map(productDto, Product.class);
//    }
}

