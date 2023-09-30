// Topic.java
package com.salomone.foro_alura;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
@Table(name = "topics")
@Entity(name = "Topic")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(unique = true)
    private String titulo;
    @NotNull
    @Column(unique = true)
    private String mensaje;
    @NotNull
    @Column(name = "fecha_Creacion")
    private Date fecha_Creacion;
    @NotNull
    private String status;
    @NotNull
    private String autor;
    @NotNull
    private String curso;


    // Getters y Setters

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public String getCurso() {
        return curso;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getAutor() {
        return autor;
    }

    public Date getFecha_Creacion() {
        return fecha_Creacion;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setFecha_Creacion(Date fecha_Creacion) {
        this.fecha_Creacion = fecha_Creacion;
    }
}
