package com.turtlemint.turtlemint.services;

import com.turtlemint.turtlemint.model.Profile;
import com.turtlemint.turtlemint.repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class ProfileServiceImplementation implements ProfileService{


    @Autowired
    private ProfileRepo profileRepo;
    @Override
    public List<Profile> allProfiles() {
        return profileRepo.findAll();
    }

    private String generateRequestId(){
        Random random = new Random();
        int rand = 0;
        while (true){
            rand = random.nextInt();
            if(rand !=0) break;
        }
        rand+=70;
        String characterSet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String encoded = "";
        int base = characterSet.length();
        int num = rand;
        while (num > 0) {
            int r = num % base;
            num = num / base;
            encoded = (characterSet.charAt(r)) + encoded;
        }
        return encoded;
    }

    @Override
    public boolean addProfile(Profile profile){
        String newRequestId;
        while (true) {
            newRequestId = generateRequestId();
            if(newRequestId.length()==0) continue;
            Optional<Profile> checkingPresence = profileRepo.findAllByRequestId(newRequestId);
            if(!checkingPresence.isPresent()) break;
        }
        profile.setRequestId(newRequestId);
        try {
            if(profile.getRequestId()==null) return false;
            profileRepo.save(profile);
        }
        catch(Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Optional<Profile> singleProfile(String requestId){
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
            profile.setRequestId(requestId);
            try {
                profileRepo.save(profile);
                return "Update Successful";
            }
            catch(Exception e) {
                return "Error, Update unsuccessful";
            }
        }
        catch (Exception e){
            return "Error, Update unsuccessful";
        }
    }
}
