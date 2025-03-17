package br.com.matrix.carrinhocompra.controlle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.matrix.carrinhocompra.model.Produto;
import br.com.matrix.carrinhocompra.service.CarrinhoService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

	@Autowired
	private CarrinhoService carrinhoService;
	
	@PostMapping("/adicionar/{produtoId}/{clienteId}")
	public ResponseEntity<String> adicionarProduto(@PathVariable Long produtoId, @PathVariable Long clienteId){
		
		carrinhoService.adicionarProduto(produtoId, clienteId);
		
		return ResponseEntity.ok("Produto adicionado ao carrinho.");
		
	}
	
	@PostMapping("/remover/{produtoId}/{clienteId}")
	public ResponseEntity<String> removerProduto(@PathVariable Long produtoId , @PathVariable Long clienteId){
		
		carrinhoService.removerProduto(produtoId, clienteId);
		
		return ResponseEntity.ok("Produto removido do carrinho");
		
	}
	
	@GetMapping("/calcularCarrinho/{clienteId}")
	public ResponseEntity<Double> calcularTotal(@PathVariable Long clienteId){
		double totalCarrinho= carrinhoService.CalcularCarrinho(clienteId);
		
		return ResponseEntity.ok(totalCarrinho);
		
	}
	
	@GetMapping("/listarProdutos/{clienteId}")
	public ResponseEntity<List<Produto>> listarProdutos(@PathVariable Long clienteId){
		
		List<Produto> produtos= carrinhoService.listarProdutos(clienteId);
		
		return ResponseEntity.ok(produtos);
		
	}
	
}
