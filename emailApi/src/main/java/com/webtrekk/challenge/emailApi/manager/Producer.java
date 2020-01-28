package com.webtrekk.challenge.emailApi.manager;

import com.webtrekk.challenge.emailApi.dto.EmailDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    private static final String TOPIC = "email_queue";

    @Autowired
    private KafkaTemplate<String, EmailDTO> kafkaTemplate;

    public void sendToEmailQueue(EmailDTO emailDTO) {
        logger.info(String.format("#### -> Queueing email -> %s", emailDTO));
        this.kafkaTemplate.send(TOPIC, emailDTO);
    }

}
