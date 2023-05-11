package com.kodigo.util;

public class Constantes {

    //endpoints
    public static final String CLIENTES = "/clientes";
    public static final String CUENTAS = "/cuentas";
    public static final String MOVIMIENTOS = "/movimientos";
    public static final String REPORTES = "/reportes";
    public static final String REPORTE_POR_MOVIMIENTOS = "/reporteMovimientos";
    public static final String PERSONAS = "/personas";
    public static final String ESPACIO = ", ";

    //base de datos
    public static final String TABLA_CLIENTE = "cliente";
    public static final String CLAVE = "clave";
    public static final String ESTADO = "estado";
    public static final String CLAVE_TENER_MINIMO_8_CARACTERES = "Clave debe tener mínimo 8 caracteres";
    public static final String ID_PERSONA = "id_persona";
    public static final String TABLA_CUENTA = "cuenta";
    public static final String CUENTA_DEBE_TENER_10_DIGITOS = "Número de cuenta debe tener 10 dígitos.";
    public static final String NUMERO_CUENTA = "numero_cuenta";
    public static final String TIPO_CUENTA_PERMITIDOS = "Tag tipoCuenta acepta los valores: AHO->ahorro | CTE->corriente";
    public static final String TIPO_CUENTA = "tipo_cuenta";
    public static final String SALDO_INICIAL = "saldo_inicial";
    public static final String SALDO_DISPONIBLE = "saldo_disponible";
    public static final String ID_CLIENTE = "id_cliente";
    public static final String TABLA_MOVIMIENTO = "movimiento";
    public static final String FECHA = "fecha";
    public static final String TIPO_MOVIMIENTO_DEBE_TENER_3_CARACTERES = "Tag tipoMovimiento debe tener 3 caracteres";
    public static final String TIPO_MOVIMIENTO = "tipo_movimiento";
    public static final String VALOR = "valor";
    public static final String SALDO = "saldo";
    public static final String ID_CUENTA = "id_cuenta";
    public static final String TABLA_PERSONA = "persona";
    public static final String NOMBRE_DEBE_TENER_MINIMO_3_CARACTERES = "Tag nombre debe tener mínimo 3 caracteres";
    public static final String GENERO_ACEPTA_MASCULINO_FEMENINO = "Tag genero acepta los valores: M->masculino | F->femenino";
    public static final String NOMBRE = "nombre";
    public static final String GENERO = "genero";
    public static final String EDAD = "edad";
    public static final String IDENTIFICACION = "identificacion";
    public static final String DIRECCION = "direccion";
    public static final String TELEFONO = "telefono";
    public static final String DIRECCION_ACEPTA_HASTA_150_CARACTERES = "Tag direccion acepta hasta 150 caracteres";
    public static final String IDENTIFICACION_DEBE_TENER_10_CARACTERES = "Tag identificacion debe tener 10 caracteres";
    public static final String TELEFONO_DEBE_TENER_10_CARACTERES = "Tag telefono debe tener 10 dígitos";
    public static final String FK_CLIENTE_PERSONA = "fk_cliente_persona";
    public static final String FK_CUENTA_CLIENTE = "fk_cuenta_cliente";
    public static final String FK_MOVIMIENTO_CUENTA = "fk_movimiento_cuenta";
    public static final String USUARIO = "usuario";

    //capa repo
    public static final String PARAM_ID_PERSONA = "idPersona";
    public static final String PARAM_FECHA_DESDE = "fechaDesde";
    public static final String PARAM_FECHA_HASTA = "fechaHasta";
    public static final String PARAM_ID_CLIENTE = "idCliente";

    //capa service
    public static final String ID_PERSONA_USADO = "idPersona ya usado";
    public static final String ID_NO_ENCONTRADO = "ID no encontrado: ";
    public static final String RETIRO = "RET";
    public static final String DEPOSITO = "DEP";
    public static final String TIPO_MOVIMIENTO_PERMITIDOS_RETIRO_DEPOSITO = "Tag tipoMovimiento acepta los valores: RE->:retiro | DEP->deposito";
    public static final String SALDO_NO_DISPONIBLE = "Saldo no disponible.";
    public static final String SIN_REGISTRO_REPORTE = "Sin Registro para este reporte idCliente: ";

    //seguridad
    public static final String USUARIO_NO_EXISTE = "Usuario no existe";
    public static final String CAMBIE_DE_USUARIO = "El usuario ya existe, por favor cambie de usuario";
    public static final String CUENTA_USADA = "Número de cuenta ya usado";

}
