package com.app.Usuario.Dao;

import com.app.Usuario.Entity.Usuario;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
 	

public interface IUsuarioDao  extends CrudRepository<Usuario,Long> {
	

	@Query(nativeQuery = true, value = "SELECT u.id, u.apelliod_paterno, u.apellido_materno, u.nombre, u.edad, u.fecha_nacimiento, u.intentos, u.nombre_usuario, r.id AS IdRol, r.NOMBRE AS NameRole FROM USUARIOS_ROLES ur  INNER JOIN USUARIO u ON UR.USUARIO_ID = U.ID  INNER JOIN ROLES r ON ur.ROLE_ID =r.ID  WHERE u.ID =:idCliente")
	List<Object[]> findUsuarioById(@Param("idCliente") Long idCliente);

}

