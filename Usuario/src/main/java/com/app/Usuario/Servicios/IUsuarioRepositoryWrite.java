package com.app.Usuario.Servicios;

import com.app.Usuario.Entity.Usuario;

import java.util.Map;

public interface IUsuarioRepositoryWrite {
    public Map<String, Object> insertar(Usuario usuario);
}
