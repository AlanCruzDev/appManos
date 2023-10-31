package com.app.perfil.Entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_sequence_generator")
    @SequenceGenerator(name = "post_sequence_generator", sequenceName = "post_sequence", allocationSize = 1)
    @Column(name="id")
    private Long Id;

    @Column(name = "post_publicacion")
    private String publicacion;

    @Temporal(TemporalType.DATE)
    private Date fechaPublicacion;

    @OneToMany(mappedBy = "post")
    private Set<PerfilPost> perfilPosts;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(String publicacion) {
        this.publicacion = publicacion;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Set<PerfilPost> getPerfilPosts() {
        return perfilPosts;
    }

    public void setPerfilPosts(Set<PerfilPost> perfilPosts) {
        this.perfilPosts = perfilPosts;
    }
}
