package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Pessoa;
import com.example.demo.service.PessoaService;

@Controller
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping("/")
	public String viewHomePage(Model model)
	{
		model.addAttribute("listPessoas", pessoaService.getAllPessoas());
		return "index";
	}
	
	@GetMapping("/formNewPessoa")
	public String formNewPessoa(Model model)
	{
		Pessoa pessoa = new Pessoa();
		model.addAttribute("pessoa", pessoa);
		return "form_new_pessoa";
		
	}
	
	@PostMapping("/savePessoa")
	public String savePessoa(@ModelAttribute("pessoa") Pessoa pessoa)
	{
		pessoaService.savePessoa(pessoa);
		return "redirect:/";
	}
	
	@GetMapping("/showFormUpdate/{id}")
	public String showFormUpdate(@PathVariable ( value = "id") long id, Model model )
	{
		Pessoa pessoa = pessoaService.getPessoaById(id);
		model.addAttribute("pessoa", pessoa);
		return "form_update_pessoa";
		
	}
	
	@GetMapping("/deletarPessoa/{id}")
	public String deletarPessoa(@PathVariable ( value = "id") long id, Model model )
	{
		this.pessoaService.delePessoaById(id);
		return "redirect:/";
	}
	
	
	
}
