package com.curso.springboot.controller;

import com.curso.springboot.dto.ProcedureDto;
import com.curso.springboot.dto.SaleDto;
import com.curso.springboot.model.Sale;
import com.curso.springboot.service.ISaleService;
import com.curso.springboot.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/sales")
public class SaleController {
    private final ISaleService saleService;
//    @Qualifier("defaultMapper")
//    private final ModelMapper modelMapper;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<SaleDto>> finAll(){
        List<SaleDto> saleDtos = mapperUtil.mapList(saleService.findAll(),SaleDto.class);

        return new ResponseEntity<>(saleDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleDto> findById(@PathVariable("id") Long id){
        Sale sale = saleService.findById(id);

        return new ResponseEntity<>(mapperUtil.map(sale,SaleDto.class),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SaleDto> save(@Valid @RequestBody SaleDto  saleDto){
        Sale sale = saleService.save(mapperUtil.map(saleDto,Sale.class));

        return new ResponseEntity<>(mapperUtil.map(sale,SaleDto.class),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> save(Long id){
        saleService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SaleDto> update(@PathVariable Long id,@Valid @RequestBody SaleDto saleDto) throws Exception {
        saleDto.setIdSale(id);
        Sale sale = saleService.update(id,mapperUtil.map(saleDto,Sale.class));

        return new ResponseEntity<>(mapperUtil.map(sale,SaleDto.class),HttpStatus.OK);
    }

    @GetMapping("/mostExpensive")
    public ResponseEntity<SaleDto> getSaleMostExpensive(){
        SaleDto saleDto = mapperUtil.map(saleService.getSAleMostExpensive(),SaleDto.class);

        return new ResponseEntity<>(saleDto,HttpStatus.OK);
    }

    @GetMapping("/sellercount")
    public ResponseEntity<Map<String,Long>> getSalesByUsers(){
        Map<String,Long> salesByUsers = saleService.getSaleCountBySeller();

        return new ResponseEntity<>(salesByUsers,HttpStatus.OK);
    }

    @GetMapping("/bestproduct")
    public ResponseEntity<Map<String,Double>> getBestProduct(){
        Map<String,Double> getBestProducts = saleService.getMostSellerProduct();

        return new ResponseEntity<>(getBestProducts,HttpStatus.OK);
    }

    @GetMapping("/resume1")
    public ResponseEntity<List<ProcedureDto>> resume1(){

        return new ResponseEntity<>(saleService.callProcedure1(),HttpStatus.OK);
    }

    @GetMapping("/resume4")
    public ResponseEntity<Void> resume4(){
        saleService.callProcedure4();
        return new ResponseEntity<>(HttpStatus.OK);
    }



//    private  SaleDto toDto(Sale sale){
//        return modelMapper.map(sale, SaleDto.class);
//    }
//
//    private Sale toEntity(SaleDto saleDto){
//        return modelMapper.map(saleDto, Sale.class);
//    }
}

