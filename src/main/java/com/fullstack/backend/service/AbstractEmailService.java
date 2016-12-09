package com.fullstack.backend.service;


import com.fullstack.web.domain.frontend.Feedback;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

public abstract class AbstractEmailService implements EmailService {

    @Value("${default.to.address}")
    private String defaultToAddress;

    protected SimpleMailMessage prepareSimpleMailMessageFromFeedback(Feedback feedback) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(defaultToAddress);
        message.setFrom(feedback.getEmail());
        message.setSubject("[FullStack]: Feedback received from " + feedback.getFirstName() + " " +
                feedback.getLastName() + " !");
        message.setText(feedback.getFeedback());
        return message;
    }

    @Override
    public void sendFeedBackEmail(Feedback feedback) {
        sendGenericEmailMessage(prepareSimpleMailMessageFromFeedback(feedback));
    }

}
