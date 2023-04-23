package com.kodigo.service;

import com.kodigo.model.Cliente;

public interface IClienteService extends ICRUD<Cliente, Integer> {

    Cliente registrarCliente(Cliente cliente);

}