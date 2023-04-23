package com.kodigo.controller;

import com.kodigo.model.Persona;
import com.kodigo.service.impl.PersonaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@WebAppConfiguration
class PersonaControllerTest {
    @Mock
    private PersonaServiceImpl service;

    @InjectMocks
    private PersonaController personaController;

    MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @DisplayName("Prueba listar OK")
    @Test
    void listar() throws Exception {
        when(service.listar()).thenReturn(Arrays.asList(Persona.builder().build()));
        ResponseEntity<List<Persona>> response = personaController.listar();
        verify(service).listar();
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @DisplayName("Prueba listarPorId")
    @Test
    void listarPorId() throws Exception {
        when(service.listarPorId(any())).thenReturn(Persona.builder().build());
        ResponseEntity<Persona> response = personaController.listarPorId(any());
        verify(service).listarPorId(any());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @DisplayName("Prueba registrar OK")
    @Test
    void registrar() throws Exception {
        when(service.registrar(any())).thenReturn(Persona.builder().build());
        ResponseEntity<Persona> response = personaController.registrar(any());
        verify(service).registrar(any());
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @DisplayName("Prueba modificar OK")
    @Test
    void modificar() throws Exception {
        when(service.modificar(any())).thenReturn(Persona.builder().build());
        ResponseEntity<Persona> response = personaController.modificar(any());
        verify(service).modificar(any());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @DisplayName("Prueba eliminarPorId OK")
    @Test
    void eliminarPorId() throws Exception {
        doNothing().when(service).eliminar(any());
        ResponseEntity<Void> response = personaController.eliminarPorId(any());
        verify(service).eliminar(any());
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

}