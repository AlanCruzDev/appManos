package com.app.perfil.Controller;


import com.app.perfil.Services.IPerfilRepositoryQuerys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PerfilController {

    @Autowired
    private IPerfilRepositoryQuerys perfilRepositoryQuerys;

    @GetMapping(value = "/post/{id_cliente}")
    public ResponseEntity<?> getPerfilandPost(@PathVariable(value = "id_cliente") int id_cliente){
        Map<String,Object> response = new HashMap<>();
        if(id_cliente == 0){
            response.put("response","Numero de cliente Obligatorio");
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.BAD_REQUEST);
        }
        response.put("response",perfilRepositoryQuerys.obtenerPerfilPost(id_cliente));
        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
    }
    @GetMapping(value = "/saludo")
    public String saludo(){
        return "HOLA MUNDO";
    }
}
