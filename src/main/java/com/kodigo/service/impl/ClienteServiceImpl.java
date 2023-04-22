package com.kodigo.service.impl;

import com.kodigo.exception.ModeloNotFoundException;
import com.kodigo.model.Cliente;
import com.kodigo.model.Persona;
import com.kodigo.repo.IClienteRepo;
import com.kodigo.repo.IGenericRepo;
import com.kodigo.repo.IPersonaRepo;
import com.kodigo.service.IClienteService;
import com.kodigo.util.Constantes;
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
            throw new ModeloNotFoundException(Constantes.ID_PERSONA_USADO);
        }

        cliente.setPersona(cargarPersona(cliente));
        return repo.save(cliente);
    }

    private Persona cargarPersona(Cliente cliente) {
        return personaRepo.getById(cliente.getPersona().getIdPersona());
    }
}
