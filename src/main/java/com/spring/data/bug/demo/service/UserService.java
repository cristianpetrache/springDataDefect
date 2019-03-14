package com.spring.data.bug.demo.service;

import com.spring.data.bug.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    private JpaRepository<User, String> userRepository;

    public UserService(
            JpaRepository<User, String> userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public User findOne(String userId) {

        return userRepository.findById(userId).orElseThrow(RuntimeException::new);
    }
}
