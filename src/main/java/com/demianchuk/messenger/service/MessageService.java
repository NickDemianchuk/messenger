package com.demianchuk.messenger.service;

import com.demianchuk.messenger.models.Message;

import java.util.ArrayList;
import java.util.List;

public class MessageService {

    public List<Message> getAllMessages() {

        Message m1 = new Message(1L, "Hello World!", "Mykola");
        Message m2 = new Message(2L, "Hello Jersey!", "Mykola");
        Message m3 = new Message(1L, "Hello REST!", "Mykola");

        List<Message> list = new ArrayList<>();
        list.add(m1);
        list.add(m2);
        list.add(m3);

        return list;
    }
}
