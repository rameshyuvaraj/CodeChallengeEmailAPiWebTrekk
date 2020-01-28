package com.webtrekk.challenge.emailApi.controller;

import com.webtrekk.challenge.emailApi.dto.EmailDTO;
import com.webtrekk.challenge.emailApi.manager.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.validation.Valid;

@RestController
@RequestMapping("api/mail")
public class EmailController {

    private static final Logger LOG = LoggerFactory.getLogger(EmailController.class);

    @Autowired
    private Producer toQueue;

    @PostMapping
    public ResponseEntity<String> sendEmail(@Valid @RequestBody EmailDTO emailDTO) {
        toQueue.sendToEmailQueue(emailDTO);
        return new ResponseEntity<>("Email Successfully Sent", HttpStatus.OK);
    }

}
