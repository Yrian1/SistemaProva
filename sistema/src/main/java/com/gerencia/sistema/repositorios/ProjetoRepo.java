package com.gerencia.sistema.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerencia.sistema.entidades.Projeto;

public interface ProjetoRepo extends JpaRepository<Projeto, Long>{

}
