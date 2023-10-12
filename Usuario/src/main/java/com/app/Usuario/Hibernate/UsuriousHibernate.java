package com.app.Usuario.Hibernate;


import com.app.Usuario.Dto.UsuarioDTO;
import com.app.Usuario.Entity.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Repository
public class UsuriousHibernate {

    @PersistenceContext
    private EntityManager em;


    @Transactional(readOnly = true)
    public Usuario findOneUserName(String username) {
        try {
            String hql = "SELECT u FROM Usuario u WHERE u.nombre LIKE :username";
            TypedQuery<Usuario> query = em.createQuery(hql, Usuario.class)
                    .setParameter("username", "%"+username+"%")
                    .setMaxResults(1);

            return query.getSingleResult();
        }catch(Exception ex) {
            System.out.println("Error Method findOneUserName: "+ex);
            return null;
        }
    }
    
    @Transactional(readOnly = true)
    public List<Object[]> findUsuarioId(Long id) {
        String sql = "	SELECT * FROM usuarios_roles ur, usuario r"
        		+ "	WHERE ur.usuario_id = r.id";
        Query q = em.createNativeQuery(sql);
        List<Object[]> data = (List<Object[]>) q.getResultList();
        return data;
    }


}
