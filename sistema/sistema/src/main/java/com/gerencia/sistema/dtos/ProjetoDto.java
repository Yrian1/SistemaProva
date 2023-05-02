package com.gerencia.sistema.dtos;

import java.util.List;
import java.util.stream.Collectors;

import com.gerencia.sistema.entidades.Categoria;
import com.gerencia.sistema.entidades.Engenheiro;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProjetoDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private double custo;
	@Enumerated(EnumType.STRING)
	private Categoria categoria=Categoria.PÚBLICO;
	public ProjetoDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	
	public static List<EngenheiroDto> converte(List<Engenheiro> lista){
		
		return lista.stream().map(EngenheiroDto::new).collect(Collectors.toList());
	}
	
}
