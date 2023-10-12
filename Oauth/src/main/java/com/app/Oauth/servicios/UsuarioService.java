package com.app.Oauth.servicios;


import java.util.List;
import java.util.stream.Collectors;

import com.app.Oauth.Modelos.Usuario;
import com.app.Oauth.usuarioFeignClient.IUsuarioFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService implements UserDetailsService,IUsuarioService {

    @Autowired
    private IUsuarioFeignClient feignClient;

    @Override
    public UserDetails loadUserByUsername(String username){
        Usuario usuario = findByUsername(username);
        if(usuario == null) {
            throw new UsernameNotFoundException("No Existe el usuario en el sistema");
        }
        System.out.println("USER: "+ usuario.getNombre());
        System.out.println("role: "+ usuario.getRoles().get(0).getNombre());
        List<GrantedAuthority> authorities = usuario.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getNombre()))
                .collect(Collectors.toList());
        return new User(usuario.getNombre(),usuario.getContrasenia(),usuario.isStatusCliente(), true, true, true, authorities);
    }

    @Override
    public Usuario findByUsername(String username) {
        return feignClient.obtenerUsuarioNombre(username);
    }




}
