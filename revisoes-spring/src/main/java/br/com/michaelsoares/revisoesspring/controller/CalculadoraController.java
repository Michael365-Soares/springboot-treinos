package br.com.michaelsoares.revisoesspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.michaelsoares.revisoesspring.model.entitys.Calc;
import br.com.michaelsoares.revisoesspring.model.entitys.Cliente;

@Controller
@RequestMapping("/calc")
public class CalculadoraController {

	@GetMapping
	 public ModelAndView calcForm(Model model) {
	   		model.addAttribute("calc",new Calc());
	   		return new ModelAndView("calc");
	 }
	
	 @PostMapping("/calculo")
	public ModelAndView resultadoCalcSoma(@ModelAttribute Calc calc) {
	    if(calc.getOp().equalsIgnoreCase("+")) {
	    	calc.somar();
	    	return new ModelAndView("result");
	    }else {
	    	calc.sub();
	    	return new ModelAndView("result");
	    }
	}
	
	 @GetMapping("/obterPorId")
	 public ModelAndView pesquisaPorId(Model model) {
	   		model.addAttribute("cliente",new Cliente());
	   		return new ModelAndView("formObterClienteId");
	 }
	 
	 @PostMapping("/obterCliente2")
	public ModelAndView obterClientePorId2(@ModelAttribute Cliente cliente) {
		cliente.setNome("Michael Soares");
		cliente.setCpf("06755140104");
		return new ModelAndView("cadastrados");
	}
	
}
