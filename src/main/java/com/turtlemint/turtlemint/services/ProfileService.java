package com.turtlemint.turtlemint.services;

import com.turtlemint.turtlemint.model.Profile;

import java.util.List;
import java.util.Optional;

public interface ProfileService {

    List<Profile> allProfiles();

    boolean addProfile(Profile profile);

    Optional<Profile> singleProfile(String requestId);

    String deleteProfile(String requestId);

    String modifyProfile(String requestId, Profile profile);
}
