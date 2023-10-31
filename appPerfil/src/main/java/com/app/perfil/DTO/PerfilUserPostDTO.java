package com.app.perfil.DTO;

public class PerfilUserPostDTO {
    private Long IdPost;
    private String Descripcion;
    private String FotoPerfil;
    private String PostJson;


    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public java.lang.Long getIdPost() {
        return IdPost;
    }

    public void setIdPost(java.lang.Long idPost) {
        IdPost = idPost;
    }

    public String getFotoPerfil() {
        return FotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        FotoPerfil = fotoPerfil;
    }

    public String getPostJson() {
        return PostJson;
    }

    public void setPostJson(String postJson) {
        PostJson = postJson;
    }
}
