package br.com.michaelsoares.revisoesspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.michaelsoares.revisoesspring.model.entitys.Produto;
import br.com.michaelsoares.revisoesspring.model.repositories.ProdutoRepository;

@Controller
@RequestMapping("produtos")
public class ProdutoController {
    @Autowired
	ProdutoRepository produtoRepository;
	
    @GetMapping
    public ModelAndView cadastrarProduto(Model model) {
    	model.addAttribute("produto",new Produto());
    	return new ModelAndView("produto/cadastroDeProdutos");
    }
    
    @PostMapping
    public ModelAndView produtoCadastrado(@ModelAttribute Produto produto){
    	produtoRepository.save(produto);
    	return new ModelAndView("produto/produtoCadastrado");
    }
    
    @GetMapping("/pesquisarPorIntervaloPreco")
    public ModelAndView pesquisarPorIntervaloDePreco() {
    	return new ModelAndView("produto/pesquisaPorIntervaloDePreco");
    }
    
    @PostMapping("/intervaloDePreco")
    public ModelAndView pesquisarProdutoPorIntervaloDePreco(double inicial,double fim,ModelMap model){
    	List<Produto> lista=produtoRepository.findByPrecoBetween(inicial, fim);
    	model.addAttribute("lista",lista);
    	return new ModelAndView("produto/produtoCadastrado2");
    }
    
}
