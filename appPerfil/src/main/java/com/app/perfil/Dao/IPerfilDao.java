package com.app.perfil.Dao;

import com.app.perfil.Entity.Perfil;
import com.app.perfil.Projections.IPerfilPostProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface IPerfilDao extends CrudRepository<Perfil,Long> {

    @Query(nativeQuery = true, value = "SELECT p.ID,p.DESCRIPCION,p.FOTO_PERFIL,(SELECT JSON_ARRAYAGG(JSON_OBJECT('ID_POST' VALUE post.ID ,'FOTO_PUBLICACION' VALUE post.FECHA_PUBLICACION)) FROM POST post INNER JOIN PERFIL_POST PP ON post.ID = PP.POST_ID WHERE PP.PERFIL_ID = p.ID) AS POST_JSON FROM  PERFIL p WHERE p.ID_CLIENTE = :id_cliente")
    List<IPerfilPostProjection> fingPerfilandPostById(@Param("id_cliente") int id_cliente);

}
