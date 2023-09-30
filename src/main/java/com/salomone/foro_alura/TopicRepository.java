package com.salomone.foro_alura;


import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    Object findByMensaje(String mensaje);

    Object findByTitulo(String titulo);
}

