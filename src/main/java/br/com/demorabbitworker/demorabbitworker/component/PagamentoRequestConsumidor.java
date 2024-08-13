package br.com.demorabbitworker.demorabbitworker.component;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class PagamentoRequestConsumidor {
    
    private PagamentoErroProdutor pagamentoErroProdutor;
    private PagamentoSucessoProdutor pagamentoSucessoProdutor;

    public PagamentoRequestConsumidor(PagamentoErroProdutor pagamentoErroProdutor, PagamentoSucessoProdutor pagamentoSucessoProdutor) {
        this.pagamentoErroProdutor = pagamentoErroProdutor;
        this.pagamentoSucessoProdutor = pagamentoSucessoProdutor;
    }

    @RabbitListener(queues = {"pagamento.request.queue"})
    public void receive(@Payload Message message) {
        System.out.println("Message: " + message + " " + LocalDateTime.now());
        String payload = String.valueOf(message.getPayload());

        if (new Random().nextBoolean()) {
            pagamentoSucessoProdutor.gerarResposta("Pagamento realizado com sucesso", payload);
        } else {
            pagamentoErroProdutor.gerarResposta("Pagamento não realizado", payload);
        }
    }


}
