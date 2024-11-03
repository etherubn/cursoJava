package com.curso.springboot.service.impl;

import com.curso.springboot.exception.ModelNotFoundException;
import com.curso.springboot.repository.IGenericRepo;
import com.curso.springboot.service.ICRUD;

import java.util.List;

public abstract class CRUDImpl<T,ID> implements ICRUD<T,ID> {

    protected abstract IGenericRepo<T,ID> getRepo();

    @Override
    public T save(T t) {
        return getRepo().save(t);
    }

    @Override
    public T update(ID id, T t){
        getRepo().findById(id).orElseThrow(()-> new ModelNotFoundException("ID NOT FOUND :"+id));
        //Java Reflextion
//        Class<?> clazz = t.getClass(); //Obteniendo la clase
//        String className = clazz.getSimpleName(); //Obteniendo el nombre de la clase
//
//        //Seteamos el id
//        String methodName = "setId"+className;
//        Method setIdMethod = clazz.getMethod(methodName,id.getClass());
//        setIdMethod.invoke(t,id);



        return getRepo().save(t);
    }

    @Override
    public List<T> findAll() {
        return getRepo().findAll();
    }

    @Override
    public void delete(ID id) {
        getRepo().findById(id).orElseThrow(()-> new ModelNotFoundException("ID NOT FOUND :"+id));
        getRepo().deleteById(id);
    }

    public T findById(ID id){
        return getRepo().findById(id).orElseThrow(()-> new ModelNotFoundException("ID NOT FOUND :"+id));
    }
}
