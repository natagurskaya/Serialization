package ua.com.gurskaya.serialization.messagestore.service;

import ua.com.gurskaya.serialization.messagestore.entity.Message;

import java.time.LocalDate;
import java.util.Collection;

public class test {
    public static void main(String[] args) {
        Message message = new Message();
        message.setId(1);
        message.setDate(LocalDate.now());
        message.setContent("Hello");

        Message messageTwo = new Message();
        messageTwo.setId(2);
        messageTwo.setDate(LocalDate.now());
        messageTwo.setContent("Hello man");

        Message message3 = new Message();
        message3.setId(3);
        message3.setDate(LocalDate.now());
        message3.setContent("Hello jjj man");

        /*LinkedList<Message> list = new LinkedList<>();
        list.add(message);
        list.add(messageTwo);*/

        //when
        SerializationMessageStore messageStore = new SerializationMessageStore("src/main/resources/rrr.ser");
        messageStore.persist(message);
        messageStore.persist(messageTwo);
        messageStore.persist(message3);
        Collection<Message> messages = messageStore.read();
        System.out.println(messages);
    }
}
