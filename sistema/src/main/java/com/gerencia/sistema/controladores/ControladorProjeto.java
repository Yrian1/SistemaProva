package com.gerencia.sistema.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerencia.sistema.dtos.ProjetoDto;
import com.gerencia.sistema.dtos.ProjetoDtoForm;
import com.gerencia.sistema.entidades.Projeto;
import com.gerencia.sistema.repositorios.AtuacoesRepo;
import com.gerencia.sistema.repositorios.ProjetoRepo;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/projetos")
public class ControladorProjeto {
	
	@Autowired
	ProjetoRepo proRepo;
	@Autowired
	AtuacoesRepo atuacoesRepo;
	
	@PostMapping
	public void cadastrar(@RequestBody @Valid Projeto projeto) {
		
		proRepo.save(projeto);
		
	}
	
	@GetMapping
	public List<ProjetoDto> Listar(){
		return ProjetoDto.converte(proRepo.findAll());
	}
	
	@PutMapping("/{id}")
	@Transactional
	public void atualizar(@PathVariable Long id, @RequestBody ProjetoDtoForm projetoDtoForm) {
		
		Optional<Projeto> projetoOpt = proRepo.findById(id);
		if(!projetoOpt.isPresent()){
			return;
		}
			Projeto projeto = projetoOpt.get();
			projeto.setNome(projetoDtoForm.getNome());
			projeto.setCusto(projetoDtoForm.getCusto());
			projeto.setCategoria(projetoDtoForm.getCategoria());
			proRepo.save(projeto);
			
		
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void deletar(@PathVariable Long id) {
		
		Optional<Projeto> projetoOpt = proRepo.findById(id);
		if(!projetoOpt.isPresent()){
			return;
		}
			
			Projeto projeto = projetoOpt.get();
			atuacoesRepo.deleteByProjetoId(id);
			proRepo.delete(projeto);
	}
	
}
