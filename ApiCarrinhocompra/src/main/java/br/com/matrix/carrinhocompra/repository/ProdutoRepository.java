package br.com.matrix.carrinhocompra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.matrix.carrinhocompra.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
