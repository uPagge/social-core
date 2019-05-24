package org.sadtech.bot.core.service.sender.email;

import org.sadtech.bot.core.domain.BoxAnswer;
import org.sadtech.bot.core.exception.MailSendException;
import org.sadtech.bot.core.service.sender.Sent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSent implements Sent {

    private static final Logger log = LoggerFactory.getLogger(Sent.class);

    private final EmailConfig emailConfig;

    public EmailSent(EmailConfig emailConfig) {
        this.emailConfig = emailConfig;
    }

    @Override
    public void send(Integer personId, String htmlText) {
        Session session = Session.getDefaultInstance(emailConfig.getProps(), new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailConfig.getUsername(), emailConfig.getPassword());
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailConfig.getUsername()));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailConfig.getUsername()));
            message.setContent(htmlText, "text/html; charset=utf-8");
            Transport.send(message);
        } catch (MessagingException e) {
            log.error(e.getMessage());
            throw new MailSendException();
        }
    }

    @Override
    public void send(Integer personId, BoxAnswer boxAnswer) {

    }
}
