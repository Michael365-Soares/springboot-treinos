package br.com.michaelsoares.revisoesspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.michaelsoares.revisoesspring.model.entitys.Produto;
import br.com.michaelsoares.revisoesspring.model.repositories.ProdutoRepository;

@Controller
@RestController
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
    	
    @GetMapping("/consultaPaginada/{numPag}")
    public ModelAndView consultaPaginada(ModelMap model,@PathVariable int numPag){
    	Pageable page=PageRequest.of(numPag,2);
    	Iterable<Produto> produtos=produtoRepository.findAll(page);
    	model.addAttribute("produtos",produtos);
    	return new ModelAndView("produto/resultPaginado");
    }
    
    @GetMapping("/pesquisarPorId")
    public ModelAndView pesquisarPorId(Model model) {
    	return new ModelAndView("produto/pesquisarPorId");
    }
    @PostMapping("/resultPesquisaId")
    public ModelAndView resultPesquisaId(int id,Model model) {
    	Produto p=produtoRepository.findById(id);
    	model.addAttribute("produto",p);
    	return new ModelAndView("produto/resultPesquisaId");
    }
    
    @GetMapping("/alterarProduto")
    public ModelAndView alterarProduto() {
    	return new ModelAndView("produto/alterarProduto");
    }
    @PostMapping("/prodAtualizado")
    public ModelAndView prodAtualizado(Model model,@ModelAttribute Produto produto) {
    	produtoRepository.save(produto);
    	model.addAttribute("produto", produto);
    	return new ModelAndView("produto/prodAtualizado");
    }
    
    
    @GetMapping("excluir")
    public ModelAndView excluir() {
    	return new ModelAndView("produto/excluirProduto");
    }
    
    @PostMapping("/excluirPorId")
    public ModelAndView excluirPorId(@RequestParam int id,Model model) {
    	produtoRepository.deleteById(id);
    	Pageable page=PageRequest.ofSize(10);
    	Iterable<Produto> produtos=produtoRepository.findAll(page);
    	model.addAttribute("produtos",produtos);
    	return new ModelAndView("produto/resultPaginado");
    }
    
    @GetMapping("/consultaPorNome/{nome}")
    public List<Produto> consultarPorNome(@PathVariable String nome){
    	List<Produto> lista=produtoRepository.findByNomeContainingIgnoreCase(nome);
    	return lista;
    }
    
}
