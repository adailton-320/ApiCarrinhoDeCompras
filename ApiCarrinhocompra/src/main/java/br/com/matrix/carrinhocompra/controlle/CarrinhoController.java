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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Carrinho de compras", description = "Endpoints para gereciamento do carrinho de compras")
@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

	@Autowired
	private CarrinhoService carrinhoService;
	
	@Operation(summary = "Inseri produto no carrino")
	@PostMapping("/adicionar/{produtoId}/{clienteId}")
	public ResponseEntity<String> adicionarProduto(@PathVariable Long produtoId, @PathVariable Long clienteId){
		
		carrinhoService.adicionarProduto(produtoId, clienteId);
		
		return ResponseEntity.ok("Produto adicionado ao carrinho.");
		
	}
	
	@Operation(summary = "Remove produto do carrino")
	@PostMapping("/remover/{produtoId}/{clienteId}")
	public ResponseEntity<String> removerProduto(@PathVariable Long produtoId , @PathVariable Long clienteId){
		
		carrinhoService.removerProduto(produtoId, clienteId);
		
		return ResponseEntity.ok("Produto removido do carrinho");
		
	}
	
	@Operation(summary = "Calcula os preços do produtos")
	@GetMapping("/calcularCarrinho/{clienteId}")
	public ResponseEntity<Double> calcularTotal(@PathVariable Long clienteId){
		double totalCarrinho= carrinhoService.CalcularCarrinho(clienteId);
		
		return ResponseEntity.ok(totalCarrinho);
		
	}
	
	@Operation(summary = "Lista os itens do carrinho")
	@GetMapping("/listarProdutos/{clienteId}")
	public ResponseEntity<List<Produto>> listarProdutos(@PathVariable Long clienteId){
		
		List<Produto> produtos= carrinhoService.listarProdutos(clienteId);
		
		return ResponseEntity.ok(produtos);
		
	}
	
}
