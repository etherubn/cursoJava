package com.curso.springboot.service.impl;

import com.curso.springboot.model.Client;
import com.curso.springboot.repository.IClientRepo;
import com.curso.springboot.repository.IGenericRepo;
import com.curso.springboot.service.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ClientServiceImpl extends CRUDImpl<Client,Long> implements IClientService {

    private final IClientRepo iClientRepo;

    @Override
    protected IGenericRepo<Client, Long> getRepo() {
        return iClientRepo;
    }
}
