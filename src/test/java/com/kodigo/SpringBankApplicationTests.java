package com.kodigo;

import com.kodigo.model.Cliente;
import com.kodigo.model.Persona;
import com.kodigo.repo.IClienteRepo;
import com.kodigo.repo.IPersonaRepo;
import org.aspectj.weaver.patterns.PerObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SpringBankApplicationTests {

	@Autowired
	private IClienteRepo repo;

	@Autowired
	private IPersonaRepo personaRepo;

	@Autowired
	private BCryptPasswordEncoder bcrypt;

	@Test
	void verificarClave() {

		//recuperar Persona
		 Persona persona = crearPersona();

		//crearCliente
		Cliente cliente = new Cliente();
		cliente.setUsuario("kodigo");
		cliente.setClave(bcrypt.encode("123456789"));
		cliente.setEstado(true);
		cliente.setPersona(persona);

		Cliente retorno = repo.save(cliente);
		assertTrue(retorno.getClave().equalsIgnoreCase(cliente.getClave()));

	}

	private Persona crearPersona() {
		Persona persona = new Persona();
		persona.setIdPersona(1);
		persona.setNombre("David Onofre");
		persona.setGenero("M");
		persona.setEdad(34);
		persona.setIdentificacion("1719382986");
		persona.setDireccion("Tambo del Inca");
		persona.setTelefono("0985559896");
		return personaRepo.save(persona);
	}

}
