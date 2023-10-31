package com.app.perfil.Entity;

import javax.persistence.*;


@Entity
@Table(name = "perfil_post")
public class PerfilPost {

    @Id
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "perfil_id")
    private Perfil perfil;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
