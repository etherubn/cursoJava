package com.curso.springboot.controller;

import com.curso.springboot.dto.UserDto;
import com.curso.springboot.model.User;
import com.curso.springboot.service.IUserService;
import com.curso.springboot.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final IUserService userService;
//    @Qualifier("defaultMapper")
//    private final ModelMapper modelMapper;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<UserDto>> finAll(){
        List<UserDto> userDtos = mapperUtil.mapList(userService.findAll(),UserDto.class);

        return new ResponseEntity<>(userDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable("id") Long id){
        User user = userService.findById(id);

        return new ResponseEntity<>(mapperUtil.map(user,UserDto.class),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDto> save(@Valid @RequestBody UserDto  userDto){
        User user = userService.save(mapperUtil.map(userDto,User.class));

        return new ResponseEntity<>(mapperUtil.map(user,UserDto.class),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> save(Long id){
        userService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@PathVariable Long id,@Valid @RequestBody UserDto userDto) throws Exception {
        userDto.setIdUser(id);
        User user = userService.update(id,mapperUtil.map(userDto,User.class));

        return new ResponseEntity<>(mapperUtil.map(user,UserDto.class),HttpStatus.OK);
    }

//    private  UserDto toDto(User user){
//        return modelMapper.map(user, UserDto.class);
//    }
//
//    private User toEntity(UserDto userDto){
//        return modelMapper.map(userDto, User.class);
//    }
}

