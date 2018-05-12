package ua.com.gurskaya.serialization.messagestore;

import org.junit.Test;
import ua.com.gurskaya.serialization.messagestore.entity.Message;
import ua.com.gurskaya.serialization.messagestore.service.MessageStore;

import java.time.LocalDate;
import java.util.Collection;

import static org.junit.Assert.assertTrue;


public abstract class AbstractMessageStoreTest {

    private MessageStore messageStore = getStore();

    abstract MessageStore getStore();

    @Test
    public void testPersistRead() {
        //prepare
        Message message = new Message();
        message.setId(1);
        message.setDate(LocalDate.now());
        message.setContent("Hello");

        Message messageTwo = new Message();
        messageTwo.setId(2);
        messageTwo.setDate(LocalDate.now());
        messageTwo.setContent("Hello man");

        /*LinkedList<Message> list = new LinkedList<>();
        list.add(message);
        list.add(messageTwo);*/

        //when
        messageStore.persist(message);
        messageStore.persist(messageTwo);
        Collection<Message> messages = messageStore.read();
        System.out.println(messages);

        //then
        assertTrue(messages.contains(message));
        assertTrue(messages.contains(messageTwo));
    }
}

