package com.curso.springboot.controller;

import com.curso.springboot.dto.ProviderDto;
import com.curso.springboot.model.Provider;
import com.curso.springboot.service.IProviderService;
import com.curso.springboot.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/providers")
public class ProviderController {
    private final IProviderService providerService;
//    @Qualifier("defaultMapper")
//    private final ModelMapper modelMapper;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<ProviderDto>> finAll(){
        List<ProviderDto> providerDtos = mapperUtil.mapList(providerService.findAll(),ProviderDto.class);

        return new ResponseEntity<>(providerDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProviderDto> findById(@PathVariable("id") Long id){
        Provider provider = providerService.findById(id);

        return new ResponseEntity<>(mapperUtil.map(provider,ProviderDto.class),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProviderDto> save(@Valid @RequestBody ProviderDto  providerDto){
        Provider provider = providerService.save(mapperUtil.map(providerDto,Provider.class));

        return new ResponseEntity<>(mapperUtil.map(provider,ProviderDto.class),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> save(Long id){
        providerService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProviderDto> update(@PathVariable Long id,@Valid @RequestBody ProviderDto providerDto) throws Exception {
        providerDto.setIdProvider(id);
        Provider provider = providerService.update(id,mapperUtil.map(providerDto,Provider.class));

        return new ResponseEntity<>(mapperUtil.map(provider,ProviderDto.class),HttpStatus.OK);
    }

//    private  ProviderDto toDto(Provider provider){
//        return modelMapper.map(provider, ProviderDto.class);
//    }
//
//    private Provider toEntity(ProviderDto providerDto){
//        return modelMapper.map(providerDto, Provider.class);
//    }
}

