package com.app.perfil.Dao;


import com.app.perfil.Entity.Post;
import org.springframework.data.repository.CrudRepository;

public interface IPostDao extends CrudRepository<Post,Long> {

}
