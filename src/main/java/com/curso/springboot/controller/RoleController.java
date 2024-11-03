package com.curso.springboot.controller;

import com.curso.springboot.dto.RoleDto;
import com.curso.springboot.model.Role;
import com.curso.springboot.service.IRoleService;
import com.curso.springboot.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/roles")
public class RoleController {
    private final IRoleService roleService;
//    @Qualifier("defaultMapper")
//    private final ModelMapper modelMapper;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<RoleDto>> finAll(){
        List<RoleDto> roleDtos = mapperUtil.mapList(roleService.findAll(),RoleDto.class);

        return new ResponseEntity<>(roleDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDto> findById(@PathVariable("id") Long id){
        Role role = roleService.findById(id);

        return new ResponseEntity<>(mapperUtil.map(role,RoleDto.class),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RoleDto> save(@Valid @RequestBody RoleDto roleDto){

        Role role = roleService.save(mapperUtil.map(roleDto,Role.class));
        return new ResponseEntity<>(mapperUtil.map(role,RoleDto.class),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> save(Long id){
        roleService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleDto> update(@PathVariable Long id,@Valid @RequestBody RoleDto roleDto) throws Exception {
        roleDto.setIdRole(id);
        Role role = roleService.update(id,mapperUtil.map(roleDto,Role.class));

        return new ResponseEntity<>(mapperUtil.map(role,RoleDto.class),HttpStatus.OK);
    }

//    private  RoleDto toDto(Role role){
//        return modelMapper.map(role, RoleDto.class);
//    }
//
//    private Role toEntity(RoleDto roleDto){
//        return modelMapper.map(roleDto, Role.class);
//    }
}

