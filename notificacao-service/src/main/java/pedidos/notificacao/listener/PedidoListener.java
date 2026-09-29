package pedidos.notificacao.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import pedidos.notificacao.entity.Pedido;
import pedidos.notificacao.service.EmailService;

@Component
public class PedidoListener {

    private final Logger logger = LoggerFactory.getLogger(PedidoListener.class);

    private final EmailService emailService;

    public PedidoListener(EmailService emailService) {

        this.emailService = emailService;
    }

    @RabbitListener(queues = "pedidos.v1.pedido-criado.gerar-notificacao")
    public void enviarNotificacao(Pedido pedido) {
        if (pedido == null || pedido.getId() == null) {
            logger.error("Recebido um pedido inválido ou com ID nulo: {}", pedido);

            throw new IllegalArgumentException("O ID do pedido não pode ser nulo.");
        }

        emailService.enviarEmail(pedido);
        logger.info("Notificação gerada com sucesso para o pedido: {}", pedido.getId());
    }
}
