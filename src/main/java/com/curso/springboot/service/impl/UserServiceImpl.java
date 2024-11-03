package com.curso.springboot.service.impl;

import com.curso.springboot.model.User;
import com.curso.springboot.repository.IGenericRepo;
import com.curso.springboot.repository.IUserRepo;
import com.curso.springboot.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl extends CRUDImpl<User,Long> implements IUserService {

    private final IUserRepo iUserRepo;

    @Override
    protected IGenericRepo<User, Long> getRepo() {
        return iUserRepo;
    }
}
