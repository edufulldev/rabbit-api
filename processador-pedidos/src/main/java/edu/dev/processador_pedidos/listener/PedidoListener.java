package edu.dev.processador_pedidos.listener;

import edu.dev.processador_pedidos.entity.Pedido;
import edu.dev.processador_pedidos.entity.enums.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PedidoListener {

    private final Logger logger = LoggerFactory.getLogger(PedidoListener.class);

    @RabbitListener(queues = "pedidos.v1.pedido-criado.gerar-processamento")
    public void salvarPedido(Pedido pedido) {
        pedido.setStatus(Status.PROCESSADO);
        logger.info("pedido foi processado: {}", pedido.toString());
    }
}
