package edu.dev.processador_pedidos.service;

import edu.dev.processador_pedidos.entity.ItemPedido;
import edu.dev.processador_pedidos.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public void save(List<ItemPedido> itens) {

        itens.forEach(item -> {
            produtoRepository.save(item.getProduto());
        });
    }
}
