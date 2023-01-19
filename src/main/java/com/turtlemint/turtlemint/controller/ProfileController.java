package com.turtlemint.turtlemint.controller;


import com.turtlemint.turtlemint.model.Profile;
import com.turtlemint.turtlemint.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turtle")
public class ProfileController {

    @Autowired
    public ProfileService profileService;

    @GetMapping("/profile")
    public ResponseEntity<List<Profile>> showAllProfiles() throws Exception{
        try {
            return new ResponseEntity<>(this.profileService.allProfiles(), HttpStatus.ACCEPTED);
        }
        catch(Exception e) {
            return new ResponseEntity<>(this.profileService.allProfiles(),HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PostMapping(value = "/profile")
    public ResponseEntity<?> addProfile(@RequestBody Profile profile)throws Exception{
        boolean status= profileService.addProfile(profile);
        if(status==true) {
            return new  ResponseEntity<>(profile, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(profile, HttpStatus.EXPECTATION_FAILED);
    }

    @GetMapping(value = "/profile/{id}")
    public ResponseEntity<?> singleProfile(@PathVariable(value = "id") String requestId){
        try{
            List<Profile> profileData=this.profileService.singleProfile(requestId);
            if(profileData.size()==0){
                return new ResponseEntity<>("Result Not Found",HttpStatus.EXPECTATION_FAILED);
            }
            else{
                return new ResponseEntity<>(profileData,HttpStatus.OK);
            }
        }
        catch (Exception e){
            return new ResponseEntity<>("Result Not Found",HttpStatus.I_AM_A_TEAPOT);
        }
    }

    @DeleteMapping (value = "/profile/{id}")
    public ResponseEntity<?> deleteProfile(@PathVariable (value = "id") String requestId){
        try{
            return new ResponseEntity<>(this.profileService.deleteProfile(requestId),HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("Not Found",HttpStatus.I_AM_A_TEAPOT);
        }
    }

    @PutMapping (value = "/profile/{id}")
    public ResponseEntity<?> modifyProfile(@RequestBody Profile profile,@PathVariable (value = "id") String requestId){
        try{
            return new ResponseEntity<>(this.profileService.modifyProfile(requestId,profile),HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("Not Found",HttpStatus.I_AM_A_TEAPOT);
        }
    }
}
