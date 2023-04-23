package com.kodigo.service.impl;

import com.kodigo.model.Cliente;
import com.kodigo.model.Cuenta;
import com.kodigo.repo.IClienteRepo;
import com.kodigo.repo.ICuentaRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class CuentaServiceImplTest {

    @Mock
    private ICuentaRepo cuentaRepo;

    @Mock
    private IClienteRepo clienteRepo;

    @InjectMocks
    private CuentaServiceImpl cuentaService;

    Cuenta cuenta;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        cargarCuenta();
    }

    @DisplayName("Prueba registrarCuenta OK")
    @Test
    void registrarCuenta() {
        when(clienteRepo.getById(any())).thenReturn(obtenerCliente());
        when(cuentaRepo.save(any())).thenReturn(Cuenta.builder().build());
        assertNotNull(cuentaService.registrarCuenta(cuenta));
    }

    private void cargarCuenta() {
        cuenta = new Cuenta();
        cuenta.setIdCuenta(1);
        cuenta.setCliente(obtenerCliente());
    }

    private Cliente obtenerCliente() {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(1);
        return cliente;
    }
}