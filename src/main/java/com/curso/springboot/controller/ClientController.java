package com.curso.springboot.controller;

import com.curso.springboot.dto.ClientDto;
import com.curso.springboot.model.Client;
import com.curso.springboot.service.IClientService;
import com.curso.springboot.util.MapperUtil;
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
@RequestMapping("/clients")
public class ClientController {
    private final IClientService clientService;
//    @Qualifier("defaultMapper")
//    private final ModelMapper modelMapper;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<ClientDto>> finAll(){
        List<ClientDto> clientDtos = mapperUtil.mapList(clientService.findAll(),ClientDto.class);

        return new ResponseEntity<>(clientDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> findById(@PathVariable("id") Long id){
        Client client = clientService.findById(id);

        return new ResponseEntity<>(mapperUtil.map(client,ClientDto.class),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClientDto> save(@Valid @RequestBody ClientDto  clientDto){
        Client client = clientService.save(mapperUtil.map(clientDto,Client.class));

        return new ResponseEntity<>(mapperUtil.map(client,ClientDto.class),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> save(Long id){
        clientService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDto> update(@PathVariable Long id,@Valid @RequestBody ClientDto clientDto) throws Exception {
        clientDto.setIdClient(id);
        Client client = clientService.update(id,mapperUtil.map(clientDto,Client.class));

        return new ResponseEntity<>(mapperUtil.map(client,ClientDto.class),HttpStatus.OK);
    }

//    private  ClientDto toDto(Client client){
//        return modelMapper.map(client, ClientDto.class);
//    }
//
//    private Client toEntity(ClientDto clientDto){
//        return modelMapper.map(clientDto, Client.class);
//    }
}

