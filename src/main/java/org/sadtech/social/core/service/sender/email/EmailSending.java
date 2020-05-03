package org.sadtech.social.core.service.sender.email;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sadtech.social.core.domain.BoxAnswer;
import org.sadtech.social.core.exception.MailSendException;
import org.sadtech.social.core.service.sender.SendType;
import org.sadtech.social.core.service.sender.Sending;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Slf4j
@RequiredArgsConstructor
public class EmailSending implements Sending {

    private final EmailConfig emailConfig;

    @Override
    public void send(@NonNull Long personId, @NonNull BoxAnswer boxAnswer) {
        Session session = Session.getDefaultInstance(emailConfig.getProps(), new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailConfig.getUsername(), emailConfig.getPassword());
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailConfig.getUsername()));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailConfig.getUsername()));
            message.setContent(boxAnswer.getMessage(), "text/html; charset=utf-8");
            Transport.send(message);
        } catch (MessagingException e) {
            log.error(e.getMessage());
            throw new MailSendException();
        }
    }

    @Override
    public void send(@NonNull Long contentId, @NonNull Long personId, @NonNull BoxAnswer boxAnswer) {
        throw new MailSendException();
    }

    @Override
    public SendType getType() {
        return SendType.PUBLIC;
    }

}
