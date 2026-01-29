package com.notificationhandler.mailing.application.service;

import com.notificationhandler.mailing.application.domain.Mail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    public void send(Mail mail) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(mail.getSender());
        simpleMailMessage.setTo(mail.getRecipients().stream().toArray(String[]::new));
        simpleMailMessage.setText(mail.getContent());
        mailSender.send(simpleMailMessage);
        log.info("Message sent to {}", mail.getRecipients().stream().collect(Collectors.joining(",")));
    }
}
