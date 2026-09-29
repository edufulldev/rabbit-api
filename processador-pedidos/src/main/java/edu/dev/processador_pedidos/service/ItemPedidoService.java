package edu.dev.processador_pedidos.service;

import edu.dev.processador_pedidos.entity.ItemPedido;
import edu.dev.processador_pedidos.entity.Pedido;
import edu.dev.processador_pedidos.repository.ItemPedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPedidoService {

    private final ItemPedidoRepository itemPedidoRepository;

    public ItemPedidoService(ItemPedidoRepository itemPedidoRepository) {
        this.itemPedidoRepository = itemPedidoRepository;
    }

    public List<ItemPedido> save(List<ItemPedido> itens) {

        return itemPedidoRepository.saveAll(itens);
    }

    public void save(ItemPedido item) {
        itemPedidoRepository.save(item);
    }

    public void updatedItemPedido(List<ItemPedido> itemPedidos, Pedido pedido) {

        itemPedidos.forEach(item -> {
            item.setPedido(pedido);
            this.save(item);
        });
    }
}
