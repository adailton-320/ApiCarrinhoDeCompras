package br.com.matrix.carrinhocompra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.matrix.carrinhocompra.model.Carrinho;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {

}
