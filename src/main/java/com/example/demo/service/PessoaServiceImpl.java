package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Pessoa;
import com.example.demo.repository.PessoaRepository;

@Service
public class PessoaServiceImpl implements PessoaService{
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Override
	public List<Pessoa> getAllPessoas()
	{
		return pessoaRepository.findAll();
	}

	@Override
	public void savePessoa(Pessoa pessoa) {
		// TODO Auto-generated method stub
		this.pessoaRepository.save(pessoa);
	}

	@Override
	public Pessoa getPessoaById(long id) {
		// TODO Auto-generated method stub
		Optional<Pessoa> optional = pessoaRepository.findById(id);
		Pessoa pessoa = null;
		
		if(optional.isPresent())
		{
			pessoa = optional.get();
		} else {
			throw new RuntimeException("Pessoa não encontrada");
		}
		
		return pessoa;
	}

	@Override
	public void delePessoaById(long id) {
		// TODO Auto-generated method stub
		this.pessoaRepository.deleteById(id);
		
	}
	
	

	
}













