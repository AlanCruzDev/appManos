package com.app.perfil.Services;

import com.app.perfil.DTO.PerfilSaveDTO;

public interface IPerfilRepositoryWrite {
    public String guardarPerfil(PerfilSaveDTO perfilSaveDTO,Integer idCliente);
}
