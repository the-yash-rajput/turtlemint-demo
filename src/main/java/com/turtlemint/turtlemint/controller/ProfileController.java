package com.turtlemint.turtlemint.controller;


import com.turtlemint.turtlemint.model.Profile;
import com.turtlemint.turtlemint.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turtle")
public class ProfileController {

    @Autowired
    public ProfileService profileService;

    @GetMapping("/profile")
    public ResponseEntity<?> showAllProfiles() throws Exception{
        try {
            List<Profile> allProfiles=this.profileService.allProfiles();
            if(allProfiles.size()!=0) {
                return new ResponseEntity<>(this.profileService.allProfiles(), HttpStatus.ACCEPTED);
            }
            else{
                return new ResponseEntity<>("NO data to display", HttpStatus.ACCEPTED);
            }
        }
        catch(Exception e) {
            return new ResponseEntity<>("Ran into some exception",HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PostMapping(value = "/profile")
    public ResponseEntity<?> addProfile(@RequestBody Profile profile)throws Exception{
        if(profile.getVehicleMake()==null || profile.getVehicleModel()==null || profile.getVertical()==null){
            return new ResponseEntity<>("Null Value Found", HttpStatus.BAD_REQUEST);
        }
        if(profile.getVertical().equals("TW") || profile.getVertical().equals("FW")) {
            boolean status = profileService.addProfile(profile);
            if (status == true) {
                return new ResponseEntity<>(profile, HttpStatus.CREATED);
            }
            return new ResponseEntity<>(profile, HttpStatus.EXPECTATION_FAILED);
        }
        else{
            return new ResponseEntity<>("Wrong Vertical Type",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/profile/{id}")
    public ResponseEntity<?> singleProfile(@PathVariable(value = "id") String requestId){
        try{
            Optional<Profile> profileData=this.profileService.singleProfile(requestId);
            if(!profileData.isPresent()){
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
