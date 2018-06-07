package com.demianchuk.messenger.models;

import javax.xml.bind.annotation.XmlRootElement;

import java.time.LocalDateTime;

@XmlRootElement
public class Profile {

    private String profileName;
    private String firstName;
    private String lastName;
    private LocalDateTime created;

    public Profile() {}

    public Profile( String profileName, String firstName, String lastName) {
        this.profileName = profileName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.created = LocalDateTime.now();
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
