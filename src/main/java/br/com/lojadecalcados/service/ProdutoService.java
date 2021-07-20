package br.com.lojadecalcados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lojadecalcados.model.Produto;
import br.com.lojadecalcados.reposistory.ProdutoReposistory;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoReposistory produtoResposistory;

	public void insert(Produto produto) {
		produtoResposistory.save(produto);
	}

	public List<Produto> list() {
		return produtoResposistory.findAll();
	}

	public Produto find(Long idProduto) {
		return produtoResposistory.findByIdProduto(idProduto);
	}
	
}
