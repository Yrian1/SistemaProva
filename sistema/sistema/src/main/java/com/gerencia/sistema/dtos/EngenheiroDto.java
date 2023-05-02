package com.gerencia.sistema.dtos;

import java.util.List;
import java.util.stream.Collectors;

import com.gerencia.sistema.entidades.Engenheiro;
import com.gerencia.sistema.entidades.Especialidade;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EngenheiroDto {

	@NotNull(message = "nome nao pode ser nullo")
	private String nome;
	@NotNull(message = "especialidade nao pode ser nullo")
	private Especialidade especialidade;


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public EngenheiroDto() {
	super();
	// TODO Auto-generated constructor stub
}

	EngenheiroDto(Engenheiro engenheiro){
		this.nome = engenheiro.getNome();
		this.especialidade = engenheiro.getEspecialidade();
	}

	public static List<EngenheiroDto> converte(List<Engenheiro> lista){
			
		return lista.stream().map(EngenheiroDto::new).collect(Collectors.toList());
	}
}
