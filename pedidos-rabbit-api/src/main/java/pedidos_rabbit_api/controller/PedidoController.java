package pedidos_rabbit_api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pedidos_rabbit_api.entity.Pedido;
import pedidos_rabbit_api.entity.enums.Status;
import pedidos_rabbit_api.service.PedidoService;

import java.time.LocalDateTime;

@Tag(name = "Pedidos", description = "Criando novo pedido")
@RestController
@RequestMapping("/api/v1/pedidos")
public class PedidoController {

    private final Logger logger = LoggerFactory.getLogger(PedidoController.class);

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @Operation(summary = "Criar novo pedido", description = "metodo para criar novo pedido",
            responses = @ApiResponse(responseCode = "201", description = "o pedido foi criado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Pedido.class))
            ))
    @PostMapping
    public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido) {
        logger.info("Pedido recebido: {}", pedido.toString());
        pedido = pedidoService.filaPedidos(pedido);
        pedido.setDataHora(LocalDateTime.now());
        pedido.setStatus(Status.EM_PROCESSAMENTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(pedido);
    }
}
