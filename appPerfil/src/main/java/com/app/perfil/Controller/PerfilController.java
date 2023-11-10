package com.app.perfil.Controller;


import com.app.perfil.DTO.PerfilSaveDTO;
import com.app.perfil.Services.IPerfilRepositoryQuerys;
import com.app.perfil.Services.IPerfilRepositoryWrite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PerfilController {

    @Autowired
    private IPerfilRepositoryQuerys perfilRepositoryQuerys;

    @Autowired
    private IPerfilRepositoryWrite iPerfilRepositoryWrite;

    @GetMapping(value = "/perfil/{id_cliente}")
    public ResponseEntity<?> getPerfilandPost(@PathVariable(value = "id_cliente") int id_cliente){
        Map<String,Object> response = new HashMap<>();
        if(id_cliente == 0){
            response.put("response","Numero de cliente Obligatorio");
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.BAD_REQUEST);
        }
        response.put("response",perfilRepositoryQuerys.obtenerPerfilPost(id_cliente));
        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
    }

    @PostMapping(value = "/perfil/save")
    public ResponseEntity<?> savePerfil(@RequestBody PerfilSaveDTO perfilSaveDTO,@PathVariable(value = "idCliente")  Integer idCliente){
        Map<String,Object> response = new HashMap<>();
        if(idCliente == null || idCliente == 0){
            response.put("response","Numero de cliente Obligatorio");
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.BAD_REQUEST);
        }
        response.put("response", iPerfilRepositoryWrite.guardarPerfil(perfilSaveDTO,idCliente));
        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
    }
    @GetMapping(value = "/saludo")
    public String saludo(){
        return "HOLA MUNDO";
    }
}
