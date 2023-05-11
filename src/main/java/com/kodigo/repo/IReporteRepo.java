package com.kodigo.repo;

import com.kodigo.model.Movimiento;
import com.kodigo.util.Constantes;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface IReporteRepo extends IGenericRepo<Movimiento, Integer> {

    @Query("FROM Movimiento c WHERE (c.cuenta.cliente.idCliente =:idCliente) AND (c.fecha BETWEEN :fechaDesde AND :fechaHasta)")
    List<Movimiento> obtenerReporte(@Param(Constantes.PARAM_FECHA_DESDE) LocalDateTime fechaDesde,
                                    @Param(Constantes.PARAM_FECHA_HASTA) LocalDateTime fechaHasta,
                                    @Param(Constantes.PARAM_ID_CLIENTE) Integer idCliente);
}
