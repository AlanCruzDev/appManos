package com.app.perfil.DTO;

import java.util.Date;


public class PostSaveDTO {

    private String fecha_publicacion;
    private String post_publicacion;
    private Long idPerfil;

    public String getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(String fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }

    public String getPost_publicacion() {
        return post_publicacion;
    }

    public void setPost_publicacion(String post_publicacion) {
        this.post_publicacion = post_publicacion;
    }

    public Long getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Long idPerfil) {
        this.idPerfil = idPerfil;
    }
}
