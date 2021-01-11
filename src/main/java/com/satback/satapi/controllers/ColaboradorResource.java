package com.satback.satapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satback.satapi.models.Colaborador;
import com.satback.satapi.repository.ColaboradorRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(value ="/api")
@Api(value="API REST Colaboradores")
public class ColaboradorResource {
	
	@Autowired
	ColaboradorRepository cr;
	
	@ApiOperation(value="Retorna uma lista com todos os colaboradores")
	@GetMapping("/pessoas")
	public List<Colaborador> listarPessoas() {
		return cr.findAll();
	}
	
	@ApiOperation(value="Retorna o colaborador do id passado como parâmetro")
	@GetMapping("/pessoa/{id}")
	public Colaborador listarPessoaUnica(@PathVariable(value="id")long id) {
		return cr.findById(id);
	}
	
	@ApiOperation(value="Salva um novo colaborador")
	@PostMapping("/pessoa")
	public Colaborador salvarColaborador(@RequestBody Colaborador colaborador) {
		return cr.save(colaborador);
	}
	
	@ApiOperation(value="Deleta o colaborador do id passado como parâmetro")
	@DeleteMapping("/pessoa")
	public void deletaColaborador(@RequestBody Colaborador colaborador) {
		cr.delete(colaborador);
	}
	
	@ApiOperation(value="Atualiza o colaborador do id passado como parâmetro")
	@PutMapping("/pessoa")
	public Colaborador atualizaColaborador(@RequestBody Colaborador colaborador) {
		return cr.save(colaborador);
	}
}
