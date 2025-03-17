package br.com.matrix.carrinhocompra.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;


@Entity
public class Carrinho implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	 @ManyToMany
	 @JoinTable(
	        name = "carrinho_produto",  // Nome da tabela de junção
	        joinColumns = @JoinColumn(name = "carrinho_id"),  // Coluna para o Carrinho
	        inverseJoinColumns = @JoinColumn(name = "produto_id")  // Coluna para o Produto
	    )
	private List<Produto> produtos= new ArrayList<Produto>();
	
	public void adicionarProduto(Produto produto) {
		produtos.add(produto);
	}
	
	public void removerProduto(Produto produto) {
		produtos.remove(produto);
	}
	
	public double calcularTotal() {
		double totalCompra= 0;
		
		for(Produto produto: produtos) {
			totalCompra += produto.getPreco();
			
		}
		
		return totalCompra;
		
	}
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	

}
