package br.com.matrix.carrinhocompra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.matrix.carrinhocompra.model.Carrinho;
import br.com.matrix.carrinhocompra.model.Cliente;
import br.com.matrix.carrinhocompra.model.Produto;
import br.com.matrix.carrinhocompra.repository.CarrinhoRepository;
import br.com.matrix.carrinhocompra.repository.ClienteRepository;
import br.com.matrix.carrinhocompra.repository.ProdutoRepository;

@Service
public class CarrinhoService {

	@Autowired
	private CarrinhoRepository carrinhoRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	public Carrinho getCarrinho(Long clienteId) {
		Cliente cliente= clienteRepository.findById(clienteId).orElse(null);
		
		if(cliente == null) {
			
			throw new RuntimeException("Cliente não encontrado.");
			
		}
		
		return cliente.getCarrinho();
		
	}
	
	public void adicionarProduto(Long clienteId, Long produtoId) {
		
		Produto produto= produtoRepository.findById(produtoId).orElse(null);
		
		if(produto == null) {
			
			throw new RuntimeException("Produto não encontrado.");
			
		}
		
		Carrinho carrinho= getCarrinho(clienteId);
		carrinho.adicionarProduto(produto);
		carrinhoRepository.save(carrinho);
		
	}
	
	public void removerProduto(Long clienteId, Long produtoId) {

		Produto produto = produtoRepository.findById(produtoId).orElse(null);

		if (produto == null) {

			throw new RuntimeException("Produto não encontrado.");

		}

		Carrinho carrinho = getCarrinho(clienteId);
		carrinho.removerProduto(produto);
		carrinhoRepository.save(carrinho);

	}
	
	public double CalcularCarrinho(Long clienteId) {
		
		Carrinho carrinho= getCarrinho(clienteId);
		
		return carrinho.calcularTotal();
		
	}
	
	public List<Produto> listarProdutos(Long clienteId){
		Carrinho carrinho= getCarrinho(clienteId);
		
		return carrinho.getProdutos();
	}
	
	
}
