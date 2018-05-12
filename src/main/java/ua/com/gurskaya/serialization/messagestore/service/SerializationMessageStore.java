package ua.com.gurskaya.serialization.messagestore.service;

import ua.com.gurskaya.serialization.messagestore.entity.Message;

import java.io.*;
import java.util.Collection;
import java.util.LinkedList;

public class SerializationMessageStore implements MessageStore {

    private String pathToFile;
    private Collection<Message> messages = new LinkedList<>();

    public SerializationMessageStore(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    @Override
    public void persist(Message message) {
        messages.add(message);
        persist(messages);
    }

    @Override
    public Collection<Message> read() {
        Collection<Message> messages;
        File file = getFile();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            messages = (Collection<Message>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Could not read data", e);
        }
        return messages;
    }

    @Override
    public void persist(Collection<Message> list) {
        File file = getFile();
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(list);
            objectOutputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException("Could not write data", e);
        }
    }
    private File getFile(){
        File file = new File(pathToFile);
        if(!file.exists()){
            throw new RuntimeException("File doesn't exist");
        }
        return file;
    }
}
