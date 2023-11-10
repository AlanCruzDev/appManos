package com.app.perfil.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "perfil")
public class Perfil implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "perfil_sequence_generator")
    @SequenceGenerator(name = "perfil_sequence_generator", sequenceName = "perfil_sequence", allocationSize = 1)
    @Column(name="id")
    private Long Id;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "foto_perfil")
    private String fotoPerfil;

    @Column(name = "descripcion")
    private String Descripcion;


    @OneToMany(mappedBy = "perfil")
    private Set<PerfilPost> perfilPosts;


    @JoinColumn(name = "cliente_id")
    private Long idCliente;


    public Set<PerfilPost> getPerfils() {
        return perfilPosts;
    }

    public void setPerfils(Set<PerfilPost> perfils) {
        this.perfilPosts = perfils;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    private static final long serialVersionUID = 1L;
}
