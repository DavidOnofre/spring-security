package com.kodigo.service.impl;

import com.kodigo.exception.ModeloNotFoundException;
import com.kodigo.model.Cliente;
import com.kodigo.model.Persona;
import com.kodigo.repo.IClienteRepo;
import com.kodigo.repo.IPersonaRepo;
import com.kodigo.util.Constantes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ClienteServiceImplTest {

    @Mock
    private IClienteRepo clienteRepo;

    @Mock
    private IPersonaRepo personaRepo;

    @Mock
    private BCryptPasswordEncoder bcrypt;

    Cliente cliente;

    @InjectMocks
    private ClienteServiceImpl clienteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        cargarCliente();
    }

    @DisplayName("Prueba registrarCliente OK")
    @Test
    void registrarCliente() {
        when(clienteRepo.consultarClientePorPersona(any())).thenReturn(null);
        when(bcrypt.encode(any())).thenReturn("clave cifrada");
        when(personaRepo.getById(any())).thenReturn(Persona.builder().build());
        when(clienteRepo.save(any())).thenReturn(Cliente.builder().build());

        assertNotNull(clienteService.registrarCliente(cliente));
    }

    @DisplayName("Prueba registrarCliente esperando excepcion")
    @Test
    void registrarClienteFallida() {
        when(clienteRepo.consultarClientePorPersona(any())).thenReturn(Cliente.builder().build());

        Exception exception = assertThrows(ModeloNotFoundException.class, () -> {
            clienteService.registrarCliente(cliente);
        });

        String expectedMessage = Constantes.ID_PERSONA_USADO;
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    private void cargarCliente() {
        cliente = new Cliente();
        cliente.setIdCliente(1);
        cliente.setEstado(true);
        cliente.setUsuario("kodigo");
        cliente.setClave("123456789");
        cliente.setPersona(obtenerPersona());
    }

    private Persona obtenerPersona() {
        Persona persona;
        persona = new Persona();
        persona.setIdPersona(1);
        persona.setNombre("David Onofre");
        persona.setGenero("M");
        persona.setEdad(34);
        persona.setIdentificacion("1719382986");
        persona.setDireccion("Tambo del Inca");
        persona.setTelefono("0985559896");
        return persona;
    }
}