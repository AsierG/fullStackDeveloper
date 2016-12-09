package com.fullstack.backend.service;


import com.fullstack.web.domain.frontend.Feedback;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

    void sendFeedBackEmail(Feedback feedback);

    void sendGenericEmailMessage(SimpleMailMessage simpleMailMessage);

}
