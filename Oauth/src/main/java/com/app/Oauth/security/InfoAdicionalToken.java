package com.app.Oauth.security;

import java.util.HashMap;
import java.util.Map;

import com.app.Oauth.Modelos.Usuario;
import com.app.Oauth.servicios.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

@Component
public class InfoAdicionalToken  implements TokenEnhancer {

    @Autowired
    private IUsuarioService usuarioService;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        Map<String, Object> info = new HashMap<>();
        System.out.println("Nombre: "+ authentication.getName());
        Usuario user = usuarioService.findByUsername(authentication.getName());
        info.put("nombre", user.getNombre());
        info.put("apellido", user.getApellidoP());
        info.put("id", user.getId());
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
        return accessToken;
    }
}
