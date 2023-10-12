package com.app.Usuario.Servicios;

import com.app.Usuario.Dao.IUsuarioDao;
import com.app.Usuario.Entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@Service
public class UsuarioRepoWriteImpl implements  IUsuarioRepositoryWrite{

    @Autowired
    private IUsuarioDao usuarioDao;
    @Autowired
    private IUsuarioRepositoryQuerys usuarioRepositoryQuerys;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public Map<String, Object> insertar(Usuario usuario) {
        Map<String,Object> response = new HashMap<>();
        try{
            usuario.setStatusCliente(true);
            Usuario response_user = usuarioRepositoryQuerys.findOneNombreUsuario(usuario.getNombreUsuario());
            if(!Objects.isNull(response_user)){
                response.put("ok","false");
                response.put("data",response_user);
                response.put("mensaje","el usuario ya existe");
                return response;
            }
            usuario.setContrasenia(passwordEncoder.encode(usuario.getContrasenia()));
            Usuario user_save = usuarioDao.save(usuario);
            response.put("ok","true");
            response.put("data",user_save);
            response.put("mensaje","usuario Guardado");
        }catch (Exception e){
                System.out.println("ERROR INSERTAR USUARIO: "+e);
        }
        return response;
    }
}
