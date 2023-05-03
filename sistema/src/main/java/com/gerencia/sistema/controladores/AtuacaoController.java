package com.gerencia.sistema.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerencia.sistema.dtos.AtuacaoDto;
import com.gerencia.sistema.entidades.Atuacao;
import com.gerencia.sistema.entidades.Engenheiro;
import com.gerencia.sistema.entidades.Projeto;
import com.gerencia.sistema.repositorios.AtuacoesRepo;
import com.gerencia.sistema.repositorios.EngenheiroRepo;
import com.gerencia.sistema.repositorios.ProjetoRepo;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/atuacoes")
public class AtuacaoController {
	
	@Autowired
	AtuacoesRepo atuacaoRepo;
	
	@Autowired
	EngenheiroRepo engRepo;
	
	@Autowired
	ProjetoRepo projRepo;
	
	@GetMapping
	public List<Atuacao> get(){
		return atuacaoRepo.findAll();
	}
	
	@PostMapping
	@Transactional
	public void post(@RequestBody AtuacaoDto atuacaoDto) {
		Atuacao atuacao = new Atuacao();
		Optional<Engenheiro> engenheiroOpt = engRepo.findById(atuacaoDto.getEngenheiro());
		if(!engenheiroOpt.isPresent()){
			return;
		}
			Engenheiro engenheiro = engenheiroOpt.get();
		atuacao.setEngenheiro(engenheiro);
		
		Optional<Projeto> projetoOpt = projRepo.findById(atuacaoDto.getProjeto());
		if(!projetoOpt.isPresent()){
			return;
		}
			Projeto projeto = projetoOpt.get();
		atuacao.setProjeto(projeto);
		
		atuacao.setDuracao(atuacaoDto.getDuracao());
		
		atuacaoRepo.save(atuacao);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void deletar(@PathVariable Long id) {
		
		Optional<Atuacao> atuacaoOpt = atuacaoRepo.findById(id);
		if(!atuacaoOpt.isPresent()){
			return;
		}
			
		Atuacao atuacao = atuacaoOpt.get();
			atuacaoRepo.delete(atuacao);
		
	}
	

}
