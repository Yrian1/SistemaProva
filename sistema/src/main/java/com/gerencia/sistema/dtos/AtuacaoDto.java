package com.gerencia.sistema.dtos;



import lombok.AllArgsConstructor;


@AllArgsConstructor

public class AtuacaoDto {
	

	private Long id;
	private Long engenheiro;
	private Long projeto;
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
	public Long getEngenheiro() {
		return engenheiro;
	}
	public void setEngenheiro(Long engenheiro) {
		this.engenheiro = engenheiro;
	}
	public Long getProjeto() {
		return projeto;
	}
	public void setProjeto(Long projeto) {
		this.projeto = projeto;
	}
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	
	

}
