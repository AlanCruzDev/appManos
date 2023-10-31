package com.app.perfil.Services;

import com.app.perfil.DTO.PerfilUserPostDTO;
import com.app.perfil.Dao.IPerfilDao;
import com.app.perfil.Projections.IPerfilPostProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PerfilRepositoryQuerysImpl implements  IPerfilRepositoryQuerys{

    @Autowired
    private IPerfilDao perfilDao;

    @Override
    public List<PerfilUserPostDTO> obtenerPerfilPost(int id_cliente) {
        String response ="";
        try{
            List<IPerfilPostProjection> listPerfil_post = perfilDao.fingPerfilandPostById(id_cliente);
            List<PerfilUserPostDTO> perfilUserPostDTOS = listPerfil_post.stream().map(datos ->{
                    PerfilUserPostDTO perfil_post = new PerfilUserPostDTO();
                    perfil_post.setIdPost(datos.getID());
                    perfil_post.setFotoPerfil(datos.getFOTO_PERFIL());
                    perfil_post.setPostJson(datos.getPOST_JSON());
                    perfil_post.setDescripcion(datos.getDESCRIPCION());
                    return perfil_post;
            }).collect(Collectors.toList());
            return perfilUserPostDTOS;
        }catch(Exception e){
            System.out.println("ERROR:"+ e);

        }

        return null;
    }
}
