package com.Paulo.devweb.repositories;

import com.Paulo.devweb.domain.Linguagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LinguagemRepository extends JpaRepository<Linguagem, Integer> {

    @Query("SELECT obj FROM Linguagem obj WHERE obj.usuario.id = :id_usu ORDER BY nome")
    List<Linguagem> findAllByUsuario(@Param(value = "id_usu") Integer id_usu);
}
