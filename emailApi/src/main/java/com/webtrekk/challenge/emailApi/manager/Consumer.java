package com.webtrekk.challenge.emailApi.manager;

import com.webtrekk.challenge.emailApi.dto.EmailDTO;
import com.webtrekk.challenge.emailApi.service.MailSenderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;

@Service
public class Consumer {

    private final Logger logger = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private MailSenderService mailSenderService;

    @KafkaListener(topics = "email_queue", groupId = "emailApiGroup",
            containerFactory = "kafkaListenerContainerFactory")
    public void consume(EmailDTO email) throws IOException {
        logger.info(String.format("#### -> Consumed email -> %s", email));
        try {
            mailSenderService.sendEmail(email);
            logger.info("Email"+email.subject);
        } catch (MessagingException e) {
            logger.error("Exception while sending email",e);
        }
    }
}
