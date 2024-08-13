package br.com.demorabbitworker.demorabbitworker.component;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
public class PagamentoErroProdutor {

    private AmqpTemplate amqpTemplate;

    public PagamentoErroProdutor(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void gerarResposta(String string, String payload) {
        amqpTemplate.convertAndSend(
            "pagamento-response-erro-exchange",
            "pagamento-response-erro-rout-key",
            string + " " + payload);
    }

}
