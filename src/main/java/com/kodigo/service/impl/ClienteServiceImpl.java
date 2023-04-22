package com.kodigo.service.impl;

import com.kodigo.exception.ModeloNotFoundException;
import com.kodigo.model.Cliente;
import com.kodigo.model.Persona;
import com.kodigo.repo.IClienteRepo;
import com.kodigo.repo.IGenericRepo;
import com.kodigo.repo.IPersonaRepo;
import com.kodigo.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl extends CRUDImpl<Cliente, Integer> implements IClienteService {

    @Autowired
    private IClienteRepo repo;

    @Autowired
    private IPersonaRepo personaRepo;

    @Override
    protected IGenericRepo<Cliente, Integer> getRepo() {
        return repo;
    }

    @Override
    public Cliente registrarCliente(Cliente cliente) {
        Cliente c = repo.consultarClientePorPersona(cliente.getPersona().getIdPersona());
        if (c != null) {
            throw new ModeloNotFoundException("idPersona ya usado");
        }

        cliente.setPersona(cargarPersona(cliente));
        return repo.save(cliente);
    }

    private Persona cargarPersona(Cliente cliente) {
        return personaRepo.getById(cliente.getPersona().getIdPersona());
    }
}
