package com.kodigo.repo;

import com.kodigo.model.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IClienteRepo extends IGenericRepo<Cliente, Integer> {

    @Query("FROM Cliente c WHERE c.persona.idPersona=:idPersona")
    Cliente consultarClientePorPersona(@Param("idPersona") Integer idPersona);

}
