package br.com.michaelsoares.revisoesspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.michaelsoares.revisoesspring.model.entitys.Cliente;

@Controller
@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
    @GetMapping
	public ModelAndView cadastro(Model model) {
		model.addAttribute("cliente",new Cliente());
		return new ModelAndView("formCadastro");
	}
    
    @GetMapping("/obterPorId")
   	public ModelAndView pesquisaPorId(Model model) {
   		model.addAttribute("cliente",new Cliente());
   		return new ModelAndView("formObterClienteId");
   	}
    
	@PostMapping
	public ModelAndView cadastrados(@ModelAttribute Cliente cliente) {
		return new ModelAndView("cadastrados");
	}
	
	@PostMapping("/obterCliente1")
	public ModelAndView obterClientePorId1(@RequestParam int id,@ModelAttribute Cliente cliente) {
		//Cliente cliente=new Cliente();
		cliente.setId(id);
		cliente.setNome("Michael Soares");
		cliente.setCpf("06755140104");
		//return cliente;
		return new ModelAndView("cadastrados");
	}
	
	@PostMapping("/obterCliente2")
	public ModelAndView obterClientePorId2(@ModelAttribute Cliente cliente) {
		cliente.setNome("Michael Soares");
		cliente.setCpf("06755140104");
		return new ModelAndView("cadastrados");
	}
	
}
