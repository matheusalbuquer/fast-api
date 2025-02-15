package com.projeto.fast_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.fast_api.entities.ObrigacaoAcessoria;

@Repository
public interface ObrigacaoAcessoriaRepository extends JpaRepository<ObrigacaoAcessoria, Long>{

}
