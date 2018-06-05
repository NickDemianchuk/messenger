package com.demianchuk.messenger.service;

import com.demianchuk.messenger.database.DatabaseClass;
import com.demianchuk.messenger.models.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MessageService {

    private Map<Long, Message> messages = DatabaseClass.getMessages();


    public MessageService() {
        messages.put(1L, new Message(1L, "Hello World", "Mykola"));
        messages.put(2L, new Message(2L, "Hello Jersey", "Mykola"));

    }
    public List<Message> getAllMessages() {
        return new ArrayList<>(messages.values());
    }

    public Message getMessage(long id) {
        return messages.get(id);
    }

    public Message addMessage(Message message) {
        message.setId(messages.size() + 1);
        messages.put(message.getId(), message);
        return message;
    }

    public Message updateMessage(Message message) {
        if(message.getId() <= 0)
            return null;
        messages.put(message.getId(), message);
        return message;
    }

    public Message removeMessage(long id) {
        return messages.remove(id);
    }
}
