package com.demianchuk.messenger.services;

import com.demianchuk.messenger.database.DatabaseClass;
import com.demianchuk.messenger.models.Profile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProfileService {

    Map<String, Profile> profiles = DatabaseClass.getProfiles();

    public List<Profile> getAllProfiles() {
        return new ArrayList<>(profiles.values());
    }

    public Profile getProfile(String profileName) {
        return profiles.get(profileName);
    }

    public Profile addProfile(Profile profile) {
        profile.setCreated(LocalDateTime.now());
        profiles.put(profile.getProfileName(), profile);
        return profile;
    }

    public Profile updateProfile(Profile profile) {
        if(profile.getProfileName().isEmpty())
            return null;
        profile.setCreated(LocalDateTime.now());
        profiles.put(profile.getProfileName(), profile);
        return profile;
    }

    public Profile removeProfile(String profileName) {
        return profiles.remove(profileName);
    }
}
