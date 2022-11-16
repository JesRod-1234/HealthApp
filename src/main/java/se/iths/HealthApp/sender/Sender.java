package se.iths.HealthApp.sender;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import se.iths.HealthApp.config.JmsConfig;
import se.iths.HealthApp.model.MessageObject;

import java.time.LocalDateTime;
import java.util.UUID;

//@Component
public class Sender {

//    private final JmsTemplate jmsTemplate;
//
//    public Sender(JmsTemplate jmsTemplate) {
//        this.jmsTemplate = jmsTemplate;
//    }
//
//    public void sendMessage() {
//        System.out.println("A new user has been saved!");
//
//        MessageObject messageObject = new MessageObject(UUID.randomUUID(), "A new user has been saved!", LocalDateTime.now());
//        jmsTemplate.convertAndSend(JmsConfig.MESSAGE_QUEUE, messageObject);
//
//        System.out.println("Message sent!");
//    }
}
