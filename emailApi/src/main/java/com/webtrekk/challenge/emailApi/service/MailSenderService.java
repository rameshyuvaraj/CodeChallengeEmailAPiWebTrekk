package com.webtrekk.challenge.emailApi.service;

import com.webtrekk.challenge.emailApi.dto.EmailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class MailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(EmailDTO emailDTO) throws MailException, MessagingException {

        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setTo(emailDTO.to_email);
        helper.setSubject(emailDTO.subject);
        helper.setText(emailDTO.textContext);
        if(emailDTO.pathToAttachment != null && !(emailDTO.pathToAttachment.isEmpty())) {
            FileSystemResource file = new FileSystemResource(new File(emailDTO.pathToAttachment));
            helper.addAttachment("attachment." + emailDTO.attachmentType, file);
        }
        javaMailSender.send(msg);

    }

}
