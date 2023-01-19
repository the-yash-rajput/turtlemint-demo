package com.turtlemint.turtlemint.services;

import com.turtlemint.turtlemint.model.Profile;

import java.util.List;

public interface ProfileService {

    List<Profile> allProfiles();

    boolean addProfile(Profile profile);

    List<Profile> singleProfile(String requestId);

    String deleteProfile(String requestId);

    String modifyProfile(String requestId, Profile profile);
}
