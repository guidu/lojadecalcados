package br.com.lojadecalcados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lojadecalcados.dto.ProdutoDTO;
import br.com.lojadecalcados.model.Produto;
import br.com.lojadecalcados.service.ProdutoService;

@RestController
@RequestMapping("/lojadecalcados/produtos")
public class ProdutoController {
	@Autowired
	private ProdutoService produtoService;
	
	@SuppressWarnings("finally")
	@PostMapping("/insert")
	public ResponseEntity<?> inserirProduto(@RequestBody ProdutoDTO produtoDTO) {
		try {
			Produto produto = produtoDTO.converteProduto();
			produtoService.insert(produto);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} finally {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<ProdutoDTO>> lista(){
		List<Produto> produtos = produtoService.list();
		produtos.forEach(s -> {
			Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProdutoController.class).find(s.getIdProduto())).withSelfRel();

			s.add(link);


		});
		List<ProdutoDTO> produtosDTO =  ProdutoDTO.listaProdutos(produtos);
		return new ResponseEntity<List<ProdutoDTO>>(produtosDTO, HttpStatus.OK);
	}
	
	
	@GetMapping("/find/{idProduto}")
	public ProdutoDTO find(@PathVariable Long idProduto){
		Produto produto = produtoService.find(idProduto);
		Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProdutoController.class).lista()).withRel("Lista de Produtos");
		produto.add(link);
		return new ProdutoDTO(produto);
	}
	
}
