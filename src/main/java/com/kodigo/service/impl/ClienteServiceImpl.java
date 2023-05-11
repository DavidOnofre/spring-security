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
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl extends CRUDImpl<Cliente, Integer> implements IClienteService {

    @Autowired
    private IClienteRepo clienteRepo;

    @Autowired
    private IPersonaRepo personaRepo;

    @Autowired
    @Lazy
    private BCryptPasswordEncoder bcrypt;

    @Override
    protected IGenericRepo<Cliente, Integer> getRepo() {
        return clienteRepo;
    }

    @Override
    public Cliente registrarCliente(Cliente cliente) {

        validarIdPersonaUsado(cliente);
        validarUsuarioUsado(cliente);

        cliente.setClave(cifrarClave(cliente));
        cliente.setPersona(cargarPersona(cliente));
        return clienteRepo.save(cliente);
    }

    private void validarIdPersonaUsado(Cliente cliente) {
        if (clienteRepo.consultarClientePorPersona(cliente.getPersona().getIdPersona()) != null) {
            throw new ModeloNotFoundException(Constantes.ID_PERSONA_USADO);
        }
    }

    private void validarUsuarioUsado(Cliente cliente) {
        if (clienteRepo.findOneByUsuario(cliente.getUsuario()) != null) {
            throw new ModeloNotFoundException(Constantes.CAMBIE_DE_USUARIO);
        }
    }

    private String cifrarClave(Cliente cliente) {
        return bcrypt.encode(cliente.getClave());
    }

    private Persona cargarPersona(Cliente cliente) {
        return personaRepo.getById(cliente.getPersona().getIdPersona());
    }
}
