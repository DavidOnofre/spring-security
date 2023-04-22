package com.kodigo.service.impl;

import com.kodigo.exception.ModeloNotFoundException;
import com.kodigo.repo.IGenericRepo;
import com.kodigo.service.ICRUD;

import java.util.List;

public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID> {

    protected abstract IGenericRepo<T, ID> getRepo();

    @Override
    public T registrar(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public T modificar(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public List<T> listar() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public T listarPorId(ID id) throws Exception {
        T t = getRepo().findById(id).orElse(null);

        if (t == null) {
            throw new ModeloNotFoundException("ID no encontrado: " + id);
        }

        return t;
    }

    @Override
    public void eliminar(ID id) throws Exception {

        T t = getRepo().findById(id).orElse(null);
        if (t == null) {
            throw new ModeloNotFoundException("ID no encontrado: " + id);
        }

        getRepo().deleteById(id);
    }
}
