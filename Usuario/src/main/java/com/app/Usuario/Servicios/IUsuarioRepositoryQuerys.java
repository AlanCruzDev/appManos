package com.app.Usuario.Servicios;

import java.util.List;

import com.app.Usuario.Dto.UsuarioDTO;
import com.app.Usuario.Entity.Usuario;

public interface IUsuarioRepositoryQuerys {
    public List<UsuarioDTO> findOneUsuario(Long id);
    public Usuario findOneNombreUsuario(String username);
    public Usuario accesoLogin(String usuario,String contrasenia);
}
