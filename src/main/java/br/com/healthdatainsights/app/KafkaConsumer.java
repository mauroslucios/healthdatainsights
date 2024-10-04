package br.com.healthdatainsights.app;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "meu_topico", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Consumindo mensagem: " + message);
    }
}
