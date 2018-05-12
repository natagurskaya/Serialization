package ua.com.gurskaya.serialization.messagestore;

import ua.com.gurskaya.serialization.messagestore.service.CustomMessageStore;
import ua.com.gurskaya.serialization.messagestore.service.MessageStore;

public class CustomMessageStoreTest extends AbstractMessageStoreTest {
    MessageStore getStore (){return new CustomMessageStore("src/test/resources/custom.ser");}
}
