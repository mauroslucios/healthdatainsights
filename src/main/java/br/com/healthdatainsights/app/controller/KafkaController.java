package br.com.healthdatainsights.app.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.healthdatainsights.app.KafkaProducer;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {

    private final KafkaProducer kafkaProducer;

    public KafkaController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publicar")
    public String enviarMensagem(@RequestParam("mensagem") String mensagem) {
        kafkaProducer.sendMessage(mensagem);
        return "Mensagem publicada com sucesso!";
    }
}
