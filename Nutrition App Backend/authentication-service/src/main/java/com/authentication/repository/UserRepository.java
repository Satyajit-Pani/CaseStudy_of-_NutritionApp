package com.authentication.repository;


import com.authentication.dto.UserDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserDto, Integer> {
    @Query(value = "{username: ?0}")
    UserDto findByUsername(String username);
}
