package com.app.perfil.Services.FuncionesOracle;

public interface IOracleFunciones {
    public String guardarPerfilCliente(String json_texto);
    public String guardarPerfil(String json_texto, Integer idCliente);
}
