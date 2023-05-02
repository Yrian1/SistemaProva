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

import com.gerencia.sistema.dtos.EngenheiroDto;
import com.gerencia.sistema.entidades.Engenheiro;
import com.gerencia.sistema.repositorios.AtuacoesRepo;
import com.gerencia.sistema.repositorios.EngenheiroRepo;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/engenheiros")
public class ControladorEngenheiro {
	
	@Autowired
	EngenheiroRepo engRepo;
	@Autowired
	AtuacoesRepo atuacoesRepo;
	
	@PostMapping
	public void cadastrar(@RequestBody @Valid Engenheiro engenheiro) {
		
		engRepo.save(engenheiro);
		
	}
	
	@GetMapping
	public List<EngenheiroDto> Listar(){
		return EngenheiroDto.converte(engRepo.findAll());
	}
	
	@PutMapping("/{id}")
	@Transactional
	public void atualizar(@PathVariable Long id, @RequestBody @Valid EngenheiroDto engenheiroDto) {
		
		Optional<Engenheiro> engenheiroOpt = engRepo.findById(id);
		if(!engenheiroOpt.isPresent()){
			return;
		}
			Engenheiro engenheiro = engenheiroOpt.get();
			engenheiro.setNome(engenheiroDto.getNome());
			engenheiro.setEspecialidade(engenheiroDto.getEspecialidade());
			engRepo.save(engenheiro);
			
		
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void deletar(@PathVariable Long id) {
		
		Optional<Engenheiro> engenheiroOpt = engRepo.findById(id);
		if(!engenheiroOpt.isPresent()){
			return;
		}
			
			Engenheiro engenheiro = engenheiroOpt.get();
			atuacoesRepo.deleteByEngenheiroId(id);
			engRepo.delete(engenheiro);
	}
	
}
