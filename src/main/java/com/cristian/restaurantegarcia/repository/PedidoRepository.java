package com.cristian.restaurantegarcia.repository;


import com.cristian.restaurantegarcia.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
