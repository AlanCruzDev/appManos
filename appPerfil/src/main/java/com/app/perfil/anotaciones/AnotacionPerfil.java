package com.app.perfil.anotaciones;

public class AnotacionPerfil {

    @JsonAtributo(nombre = "descripcion")
    private String Descripcion;

    @JsonAtributo(nombre = "foto_perfil")
    private String FotoPerfil;

    @JsonAtributo(nombre = "id_cliente")
    private String IdCliente;

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getFotoPerfil() {
        return FotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        FotoPerfil = fotoPerfil;
    }

    public String getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(String idCliente) {
        IdCliente = idCliente;
    }
}
