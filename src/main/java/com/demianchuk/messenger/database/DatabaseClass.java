package com.demianchuk.messenger.database;

import com.demianchuk.messenger.models.Message;
import com.demianchuk.messenger.models.Profile;

import java.util.HashMap;
import java.util.Map;

public class DatabaseClass {

    private static Map<Long, Message> messages = new HashMap<>();
    private static Map<String, Profile> profiles = new HashMap<>();

    static {
        messages.put(1L, new Message(1L, "Hello World", "Mykola"));
        messages.put(2L, new Message(2L, "Hello Jersey", "Mykola"));

        profiles.put("nickdemianchuk", new Profile("nickdemianchuk", "Mykola", "Demianchuk"));
    }

    public static Map<Long, Message> getMessages() {
        return messages;
    }

    public static Map<String, Profile> getProfiles() {
        return profiles;
    }
}