package com.turtlemint.turtlemint.services;

import com.turtlemint.turtlemint.model.Profile;
import com.turtlemint.turtlemint.repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImplementation implements ProfileService{


    @Autowired
    private ProfileRepo profileRepo;
    @Override
    public List<Profile> allProfiles() {
        return profileRepo.findAll();
    }

    @Override
    public boolean addProfile(Profile profile){
        try {
            profileRepo.save(profile);
        }
        catch(Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public List<Profile> singleProfile(String requestId){
        return profileRepo.findAllByRequestId(requestId);
    }

    @Override
    public String deleteProfile(String requestId){
        try {
            profileRepo.deleteByRequestId(requestId);
            return "Profile Deleted";
        }
        catch (Exception e){
            return "Error, Delete unsuccessful";
        }
    }

    @Override
    public String modifyProfile(String requestId, Profile profile) {
        try{
            profileRepo.deleteByRequestId(requestId);
            profileRepo.save(profile);
            return "Update Successful";
        }
        catch (Exception e){
            return "Error, Update unsuccessful";
        }
    }
}
