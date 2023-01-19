package com.turtlemint.turtlemint.repository;

import com.turtlemint.turtlemint.model.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfileRepo extends MongoRepository<Profile,Integer> {
    Optional<Profile> findAllByRequestId(String requestId);

    void deleteByRequestId(String requestId);
}

