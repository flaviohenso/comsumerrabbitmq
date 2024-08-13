package br.com.demorabbitworker.demorabbitworker.component;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
public class PagamentoSucessoProdutor {

    private AmqpTemplate amqpTemplate;

    public PagamentoSucessoProdutor(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void gerarResposta(String string, String payload) {
        amqpTemplate.convertAndSend(
            "pagamento-response-sucesso-exchange",
            "pagamento-response-sucesso-rout-key",
            string + " " + payload);
    }

}
