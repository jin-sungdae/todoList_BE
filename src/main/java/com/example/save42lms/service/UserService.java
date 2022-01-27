package com.example.save42lms.service;

import com.example.save42lms.model.UserEntity;
import com.example.save42lms.persistence.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity create(final UserEntity userEntity){
        if (userEntity == null || userEntity.getEmail() == null){
            throw new RuntimeException("Invaild arguments");
        }
        final String email = userEntity.getEmail();
        if (userRepository.existsByEmail(email)){
            log.warn("Email already exists {}", email);
            throw new RuntimeException("Email already exists");
        }
        return userRepository.save(userEntity);
    }

    public UserEntity getByCredentials(final String email, final String password){
        return userRepository.findByEmailAndPassword(email, password);
    }
}
