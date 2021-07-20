package br.com.lojadecalcados.reposistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lojadecalcados.model.Produto;

@Repository
public interface ProdutoReposistory extends JpaRepository<Produto, Long>{
	Produto findByIdProduto(Long id);
}
