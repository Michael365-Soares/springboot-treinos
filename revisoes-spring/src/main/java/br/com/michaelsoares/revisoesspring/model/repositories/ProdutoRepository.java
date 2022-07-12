package br.com.michaelsoares.revisoesspring.model.repositories;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.michaelsoares.revisoesspring.model.entitys.Produto;

public interface ProdutoRepository extends JpaRepository<Produto,Integer> {
    
	public Produto findById(int id);
	
	public List<Produto> findByPreco(double preco);
	
	public List<Produto> findByDesconto(double desconto);
	
	public List<Produto> findByPrecoAndDesconto(double preco,double desconto);
	
	public List<Produto> findByPrecoBetween(double precoInical,double precoFinal);
	
	@Query("from Produto where nome like %:nome%")
	public List<Produto> findByNome(@Param("nome") String nome);
	
	@Query("from Produto where preco=?1 and id>=?2")
	public List<Produto> findByPrecoAndId(int id,double preco);
	
	public List<Produto> findByNomeContainingIgnoreCase(String parteNome);
	
}
