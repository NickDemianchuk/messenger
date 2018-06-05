package com.demianchuk.messenger.service;

import com.demianchuk.messenger.database.DatabaseClass;
import com.demianchuk.messenger.models.Profile;

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
        profile.setId(profiles.size() + 1);
        return profiles.put(profile.getProfileName(), profile);
    }

    public Profile updateProfile(Profile profile) {
        if(profile.getId() <= 0)
            return null;
        profiles.put(profile.getProfileName(), profile);
        return profile;
    }

    public Profile removeProfile(String profileName) {
        return profiles.remove(profileName);
    }
}
