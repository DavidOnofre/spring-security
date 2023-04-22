package com.kodigo.service.impl;

import com.kodigo.model.Persona;
import com.kodigo.repo.IGenericRepo;
import com.kodigo.repo.IPersonaRepo;
import com.kodigo.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl extends CRUDImpl<Persona, Integer> implements IPersonaService {

    @Autowired
    private IPersonaRepo repo;

    @Override
    protected IGenericRepo<Persona, Integer> getRepo() {
        return repo;
    }

}
