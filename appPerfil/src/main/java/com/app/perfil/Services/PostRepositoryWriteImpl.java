package com.app.perfil.Services;

import com.app.perfil.DTO.PostSaveDTO;
import com.app.perfil.Services.FuncionesOracle.IOracleFunciones;
import com.app.perfil.anotaciones.AnotacionPost;
import com.app.perfil.procesador.JsonSerializador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PostRepositoryWriteImpl implements IPostRepositoryWrite {

    @Autowired
    private IOracleFunciones iOracleFunciones;

    @Override
    public String guardarPost(PostSaveDTO postSaveDTO) {
        String response ="";
        AnotacionPost post = new AnotacionPost();
        try{
            post.setPost_publicacion(postSaveDTO.getPost_publicacion());
            post.setFecha_publicacion(postSaveDTO.getFecha_publicacion());
            post.setIdPerfil(postSaveDTO.getIdPerfil());
            String _data = JsonSerializador.ConvertJson(post);
            System.out.println("JSON: "+ _data);
            response = iOracleFunciones.guardarPerfilCliente(_data);

        }catch (Exception e){
            System.out.println("ERROR METHOD guardarPost: " + e);
        }
        return response;
    }
}
