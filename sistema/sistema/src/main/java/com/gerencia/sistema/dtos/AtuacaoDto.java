package com.gerencia.sistema.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AtuacaoDto {
	

	private Long id;
	private EngenheiroDto engenheiro;
	private ProjetoDto projeto;
	private int duracao;
	public AtuacaoDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public EngenheiroDto getEngenheiro() {
		return engenheiro;
	}
	public void setEngenheiro(EngenheiroDto engenheiro) {
		this.engenheiro = engenheiro;
	}
	public ProjetoDto getProjeto() {
		return projeto;
	}
	public void setProjeto(ProjetoDto projeto) {
		this.projeto = projeto;
	}
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	
	

}
