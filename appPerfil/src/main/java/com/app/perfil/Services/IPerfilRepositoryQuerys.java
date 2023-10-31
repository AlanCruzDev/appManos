package com.app.perfil.Services;

import com.app.perfil.DTO.PerfilUserPostDTO;

import java.util.List;

public interface IPerfilRepositoryQuerys {
    public List<PerfilUserPostDTO>  obtenerPerfilPost(int id_cliente);
}
