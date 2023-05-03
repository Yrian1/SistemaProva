package com.gerencia.sistema.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerencia.sistema.entidades.Atuacao;

public interface AtuacoesRepo extends JpaRepository<Atuacao, Long>{

	public void deleteByEngenheiroId(Long Id);
	
	public void deleteByProjetoId(Long Id);
}
