package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Pessoa;

public interface PessoaService {

	List<Pessoa> getAllPessoas();
	void savePessoa(Pessoa pessoa);
	Pessoa getPessoaById(long id);
	void delePessoaById(long id);
}
