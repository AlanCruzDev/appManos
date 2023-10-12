package com.app.Usuario.Controller;


import com.app.Usuario.Entity.Usuario;
import com.app.Usuario.Servicios.IUsuarioRepositoryQuerys;
import com.app.Usuario.Servicios.IUsuarioRepositoryWrite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UsuarioController {

    @Autowired
    private IUsuarioRepositoryWrite usuarioRepositoryWrite;

    @Autowired
    private IUsuarioRepositoryQuerys usuarioRepositoryQuerys;

    @GetMapping(value = "/one/user/{id}")
    public ResponseEntity<?> getOneUser(@PathVariable(value = "id") Long id){
        Map<String,Object> response = new HashMap<>();
        if(id == null || id == 0) {
            response.put("response","Numero de Cliente Obligatorio");
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.BAD_REQUEST);
        }
        response.put("response", usuarioRepositoryQuerys.findOneUsuario(id));
        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<?> guardarUsuario(@RequestBody Usuario usuario){
        Map<String,Object> response = new HashMap<>();
        try{
            response = usuarioRepositoryWrite.insertar(usuario);
            boolean bnd = (boolean) response.get("ok");
            if(bnd == false){
                return new ResponseEntity<Map<String,Object>>(response,HttpStatus.FOUND);
            }
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/user/{username}")
    public Usuario obtenerUsuarioNombre(@PathVariable("username") String username){
        return usuarioRepositoryQuerys.findOneNombreUsuario(username);
    }

}
