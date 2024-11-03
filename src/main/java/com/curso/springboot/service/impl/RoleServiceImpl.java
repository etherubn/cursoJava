package com.curso.springboot.service.impl;

import com.curso.springboot.model.Role;
import com.curso.springboot.repository.IGenericRepo;
import com.curso.springboot.repository.IRoleRepo;
import com.curso.springboot.service.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RoleServiceImpl extends CRUDImpl<Role,Long> implements IRoleService {

    private final IRoleRepo iRoleRepo;

    @Override
    protected IGenericRepo<Role, Long> getRepo() {
        return iRoleRepo;
    }
}
