package com.gerencia.sistema.dtos;

import com.gerencia.sistema.entidades.Categoria;

public class ProjetoDtoForm {
	
	private String nome;
	private double custo;
	private Categoria categoria=Categoria.PUBLICO;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getCusto() {
		return custo;
	}
	public void setCusto(double custo) {
		this.custo = custo;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	

}
