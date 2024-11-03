package com.curso.springboot.service.impl;

import com.curso.springboot.model.Provider;
import com.curso.springboot.repository.IProviderRepo;
import com.curso.springboot.repository.IGenericRepo;
import com.curso.springboot.service.IProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProviderServiceImpl extends CRUDImpl<Provider,Long> implements IProviderService {

    private final IProviderRepo iProviderRepo;

    @Override
    protected IGenericRepo<Provider, Long> getRepo() {
        return iProviderRepo;
    }
}
