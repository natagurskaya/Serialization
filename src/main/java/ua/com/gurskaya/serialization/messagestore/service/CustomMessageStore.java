package ua.com.gurskaya.serialization.messagestore.service;

import ua.com.gurskaya.serialization.messagestore.entity.Message;

import java.io.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedList;

public class CustomMessageStore implements MessageStore {

    private String pathToFile;

    public CustomMessageStore(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    @Override
    public void persist(Message message) {
        File file = getFile();
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file, true))) {
            dataOutputStream.writeInt(message.getId());
            dataOutputStream.writeUTF(String.valueOf(message.getDate()));
            dataOutputStream.writeUTF(message.getContent());
        } catch (IOException e) {
            throw new RuntimeException("Could not write data", e);
        }
    }

    @Override
    public Collection<Message> read() {
        Collection<Message> messages = new LinkedList<>();
        File file = getFile();
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file))) {
            while (dataInputStream.available() > 0) {
                Message message = new Message();
                message.setId(dataInputStream.readInt());
                message.setDate(LocalDate.parse(dataInputStream.readUTF()));
                message.setContent(dataInputStream.readUTF());
                messages.add(message);
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not read data", e);
        }
        return messages;
    }

    @Override
    public void persist(Collection<Message> list) {
        File file = getFile();
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file, true))) {
            for (Message message : list) {
                dataOutputStream.writeInt(message.getId());
                dataOutputStream.writeUTF(String.valueOf(message.getDate()));
                dataOutputStream.writeUTF(message.getContent());
            }
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