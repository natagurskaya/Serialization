package ua.com.gurskaya.serialization.messagestore;

import org.junit.Before;
import org.junit.Test;
import ua.com.gurskaya.serialization.messagestore.entity.Message;
import ua.com.gurskaya.serialization.messagestore.service.MessageStore;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Collection;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;


public abstract class AbstractMessageStoreTest {

    private MessageStore messageStore = getStore();

    abstract MessageStore getStore();

    abstract String getPath();

    @Before
    public void setFile() throws IOException {
        File file = new File(getPath());
        if (file.exists()) {
            file.delete();
            file.createNewFile();
        }
    }

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

        //when
        messageStore.persist(message);
        messageStore.persist(messageTwo);
        Collection<Message> messages = messageStore.read();

        //then
        assertEquals(2, messages.size());
    }
}

