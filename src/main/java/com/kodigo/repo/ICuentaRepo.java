package com.kodigo.repo;

import com.kodigo.model.Cliente;
import com.kodigo.model.Cuenta;

public interface ICuentaRepo extends IGenericRepo<Cuenta, Integer> {

    Cuenta findOneByNumeroCuenta(String numeroCuenta);
}
