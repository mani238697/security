package com.security.applicationsecure.services;

import com.security.applicationsecure.entities.User;
import com.security.applicationsecure.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return (User) userRepository.findById(id).orElse(null);
    }

    public User saveUser(User user){
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        return userRepository.save(user);
    }
    public void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("User with id " + id + " not found");
        }
    }
    @Transactional
    public void deleteAllUsers() {
        userRepository.deleteAll();
        // resetIdSequence();
    }

    public User getUserByusernameAndPassword(String username, String password) {
        return userRepository.findByusernameAndPassword(username, password);
    }
    public User getUserByUsername(String username) {
        return userRepository.findByusername(username);
    }


}
