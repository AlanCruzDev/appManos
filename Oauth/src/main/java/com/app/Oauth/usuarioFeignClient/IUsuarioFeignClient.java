package com.app.Oauth.usuarioFeignClient;


import com.app.Oauth.Modelos.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "servicio-usuario")
public interface IUsuarioFeignClient {

    @GetMapping("/user/{username}")
    public Usuario obtenerUsuarioNombre(@PathVariable("username") String username);
}
