package edu.dev.processador_pedidos.repository;

import edu.dev.processador_pedidos.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, UUID> {
}
