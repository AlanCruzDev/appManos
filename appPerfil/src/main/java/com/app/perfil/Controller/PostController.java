package com.app.perfil.Controller;


import com.app.perfil.DTO.PostSaveDTO;
import com.app.perfil.Services.IPostRepositoryWrite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class PostController {

    @Autowired
    private IPostRepositoryWrite iPostRepositoryWrite;

    @PostMapping("/post/save")
    public ResponseEntity<?> guardarPostUsuario(@RequestBody  PostSaveDTO postSaveDTO){
        Map<String,Object> response = new HashMap<>();
        try{
            String data = iPostRepositoryWrite.guardarPost(postSaveDTO);
            response.put("response", data);
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
