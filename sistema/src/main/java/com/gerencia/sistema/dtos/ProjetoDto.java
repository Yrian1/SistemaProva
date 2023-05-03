package com.gerencia.sistema.dtos;

import java.util.List;
import java.util.stream.Collectors;



import com.gerencia.sistema.entidades.Categoria;
import com.gerencia.sistema.entidades.Projeto;

import lombok.AllArgsConstructor;


@AllArgsConstructor

public class ProjetoDto {

	private String nome;
	private Categoria categoria=Categoria.PUBLICO;
	public ProjetoDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	 ProjetoDto(Projeto projeto) {
			super();
			this.nome = projeto.getNome();
			this.categoria = projeto.getCategoria();
				
			// TODO Auto-generated constructor stub
	}
	public static List<ProjetoDto> converte(List<Projeto> lista){
		
		return lista.stream().map(ProjetoDto::new).collect(Collectors.toList());
	}
	
}
