package ua.com.gurskaya.serialization.messagestore.service;

import ua.com.gurskaya.serialization.messagestore.entity.Message;

import java.util.Collection;

public interface MessageStore {

    void persist(Message message);

    Collection<Message> read();

    void persist(Collection<Message> list);
}
