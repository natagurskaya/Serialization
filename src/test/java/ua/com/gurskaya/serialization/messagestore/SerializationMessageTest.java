package ua.com.gurskaya.serialization.messagestore;

import ua.com.gurskaya.serialization.messagestore.service.MessageStore;
import ua.com.gurskaya.serialization.messagestore.service.SerializationMessageStore;


public class SerializationMessageTest extends AbstractMessageStoreTest {
    MessageStore getStore() {
        return new SerializationMessageStore("src/test/resources/serialized.ser");
    }

    @Override
    String getPath() {
        return "src/test/resources/serialized.ser";
    }
}
