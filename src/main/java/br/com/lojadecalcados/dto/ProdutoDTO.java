package br.com.lojadecalcados.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Links;

import br.com.lojadecalcados.model.Produto;

public class ProdutoDTO {
	private Long idProduto;
	private String nome;
	private BigDecimal valorReal;
	private BigDecimal valorVenda;
	private String modelo;
	private String fornecedor;
	private Links links;

	
	public ProdutoDTO() {
	}	
	
	public ProdutoDTO(Produto produto) {
		this.idProduto = produto.getIdProduto();
		this.nome = produto.getNome();
		this.valorReal = produto.getValorReal();
		this.valorVenda = produto.getValorVenda();
		this.modelo = produto.getModelo();
		this.fornecedor = produto.getFornecedor();
		this.links = produto.getLinks();
	}
	
	public Long getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigDecimal getValorReal() {
		return valorReal;
	}
	public void setValorReal(BigDecimal valorReal) {
		this.valorReal = valorReal;
	}
	public BigDecimal getValorVenda() {
		return valorVenda;
	}
	public void setValorVenda(BigDecimal valorVenda) {
		this.valorVenda = valorVenda;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	public Links getLinks() {
		return links;
	}

	public void setLinks(Links links) {
		this.links = links;
	}

	public static List<ProdutoDTO> listaProdutos(List<Produto> produtos) {
		return produtos.stream().map(ProdutoDTO::new).collect(Collectors.toList());
	}

	public Produto converteProduto() {
		return new Produto(idProduto, nome, valorReal, valorVenda, modelo, fornecedor);
	}

}
