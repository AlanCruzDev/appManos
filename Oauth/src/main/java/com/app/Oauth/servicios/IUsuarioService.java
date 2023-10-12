package com.app.Oauth.servicios;

import com.app.Oauth.Modelos.Usuario;

public interface IUsuarioService {
    public Usuario findByUsername(String username);
}
