package com.turtlemint.turtlemint.repository;

import com.turtlemint.turtlemint.model.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProfileRepo extends MongoRepository<Profile,Integer> {
    List<Profile> findAllByRequestId(String requestId);

    void deleteByRequestId(String requestId);
}

