package com.Paulo.devweb.repositories;

import com.Paulo.devweb.domain.Linguagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinguagemRepository extends JpaRepository<Linguagem, Integer> {
}
