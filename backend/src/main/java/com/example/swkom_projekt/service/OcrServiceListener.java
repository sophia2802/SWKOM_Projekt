package com.example.swkom_projekt.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


@Service
public class OcrServiceListener {
    @RabbitListener(queues = "ocrResultQueue")
    public void receiveOcrResult(String ocrText) {
        System.out.println("Received OCR result: " + ocrText);
    }
}
