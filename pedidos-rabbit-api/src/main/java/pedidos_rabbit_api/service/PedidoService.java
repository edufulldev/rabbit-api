package pedidos_rabbit_api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pedidos_rabbit_api.entity.Pedido;

@Service
public class PedidoService {

    private final Logger logger = LoggerFactory.getLogger(PedidoService.class);

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

   @Autowired
    private RabbitTemplate rabbitTemplate;

   public Pedido filaPedidos(Pedido pedido) {
       rabbitTemplate.convertAndSend(exchangeName, "", pedido);
       logger.info("fila de pedidos: {}", pedido.toString());
       return pedido;
   }
}
