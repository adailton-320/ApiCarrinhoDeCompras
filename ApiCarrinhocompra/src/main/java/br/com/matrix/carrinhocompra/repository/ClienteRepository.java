package br.com.matrix.carrinhocompra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.matrix.carrinhocompra.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
