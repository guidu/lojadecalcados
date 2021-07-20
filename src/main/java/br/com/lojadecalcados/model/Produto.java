package br.com.lojadecalcados.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;

import br.com.lojadecalcados.dto.ProdutoDTO;

@Entity
@Table(name = "tbproduto")
public class Produto extends RepresentationModel<Produto> {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "idproduto")
	private Long idProduto;
	@Column(name = "nome")
	private String nome;
	@Column(name = "valorreal")
	private BigDecimal valorReal;
	@Column(name = "valorvenda")
	private BigDecimal valorVenda;
	@Column(name = "modelo")
	private String modelo;
	@Column(name = "fornecedor")
	private String fornecedor;

	public Produto(ProdutoDTO produtoDTO) {
		this.nome = produtoDTO.getNome();
		this.valorReal = produtoDTO.getValorReal();
		this.valorVenda = produtoDTO.getValorVenda();
		this.modelo = produtoDTO.getModelo();
		this.fornecedor = produtoDTO.getFornecedor();
	}

	public Produto(Long idProduto, String nome, BigDecimal valorReal, BigDecimal valorVenda, String modelo,
			String fornecedor) {
		this.idProduto = idProduto;
		this.nome = nome;
		this.valorReal = valorReal;
		this.valorVenda = valorVenda;
		this.modelo = modelo;
		this.fornecedor = fornecedor;
	}

	public Produto() {
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

}
