package com.userprofile.service.service;

import com.userprofile.service.exception.UserBadRequestException;
import com.userprofile.service.model.User;
import com.userprofile.service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final SequenceGeneratorService sequenceGeneratorService;

    public User addUser(User user){
        try {
            user.setUserId(sequenceGeneratorService.getSequenceNumber("user_sequence"));
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//            user.setPassword(user.getPassword());
            log.info("Created data : " + user);
            return userRepository.save(user);
        } catch (Exception exception) {
            throw new UserBadRequestException("Exception occurred while saving data in db :  " + exception.getMessage());
        }
    }

}
