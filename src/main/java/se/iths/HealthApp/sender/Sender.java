package se.iths.HealthApp.sender;

import org.springframework.jms.core.JmsTemplate;

public class Sender {

    private final JmsTemplate jmsTemplate;

    public Sender(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(){
        System.out.println("A new user has been saved!");
    }
}
