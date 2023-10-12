package com.app.Usuario.Servicios;

import com.app.Usuario.Dao.IUsuarioDao;
import com.app.Usuario.Dto.RolesDTO;
import com.app.Usuario.Dto.UsuarioDTO;
import com.app.Usuario.Entity.Usuario;
import com.app.Usuario.Hibernate.UsuriousHibernate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UsuarioRepositoryQuerysImpl  implements  IUsuarioRepositoryQuerys{


    @Autowired
    private IUsuarioDao usuarioDao;
    
    @Autowired
    private UsuriousHibernate usuriousHibernate;
    
    
    
    @Override
    public List<UsuarioDTO> findOneUsuario(Long idCliente) {
    	List<UsuarioDTO> usuarioDTOs = new ArrayList<>();
    	
    	try {
    		System.out.println("ID ES: "+idCliente);
    		List<Object[]> data_resultado = usuarioDao.findUsuarioById(idCliente);
    		
    		for(int i=0; i< data_resultado.size(); i++){
    			Object [] o= data_resultado.get(i);
    			UsuarioDTO usuarioDTO = new UsuarioDTO();
                usuarioDTO.setId(((BigDecimal) o[0]).longValue());
    			usuarioDTO.setApellidoP((String) o[1]);
    			usuarioDTO.setApellidoM((String)o[2]);
    			usuarioDTO.setNombre((String) o[3]);
                usuarioDTO.setEdad(((BigDecimal) o[4]).intValue());
                usuarioDTO.setIntentos(((BigDecimal) o[6]).intValue());
    			usuarioDTO.setNombreUsuario((String) o[7]);
    			
    			List<RolesDTO> rolesDTOL = new ArrayList<>();
    			RolesDTO rolesDTO = new RolesDTO();
                rolesDTO.setId(((BigDecimal) o[8]).longValue());
    			rolesDTO.setNombre((String) o[9]);
    			rolesDTOL.add(rolesDTO);
    			usuarioDTO.setRolesdto(rolesDTOL);
    			usuarioDTOs.add(usuarioDTO);
    			
    		}
    		System.out.println("DATA: "+ data_resultado.size());
    	
    		
    	}catch(Exception e) {
    		System.out.println("Error METHOD findOneUsuario: "+e);
    	}
    	
    	// return usuarioDao.findById(id).orElse(null);
    	return usuarioDTOs;
    }
    
    

    @Override
    public Usuario findOneNombreUsuario(String username) {
        return usuriousHibernate.findOneUserName(username);
    }
}
