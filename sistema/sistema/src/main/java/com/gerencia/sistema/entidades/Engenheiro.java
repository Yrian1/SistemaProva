	package com.gerencia.sistema.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity(name = "engenheiros")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class Engenheiro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull(message = "nome nao pode ser nullo")
	private String nome;
	private String CREA;
	@Enumerated(EnumType.STRING)
	@NotNull(message = "especialidade nao pode ser nullo")
	private Especialidade especialidade=Especialidade.CIVIL;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCREA() {
		return CREA;
	}
	public void setCREA(String cREA) {
		CREA = cREA;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}
	public String getNome() {
		return this.nome;
	}
	public Especialidade getEspecialidade() {
		return this.especialidade;
	}
	

}
