package com.codecool.NorthwindPractice.service;

import com.codecool.NorthwindPractice.model.User;
import com.codecool.NorthwindPractice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailsManager userDetailsManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Iterable<User> getAll() {
        return userRepository.findAll();
    }

    public Optional<User> get(String username) {
        return userRepository.findByUsername(username);
    }

    @Transactional
    public User add(String username, String email, String password, String confirmationPassword) {
        if (!password.equals(confirmationPassword)) {
            throw new IllegalArgumentException();
        }

        userDetailsManager.createUser(new org.springframework.security.core.userdetails.User(
            username,
            passwordEncoder.encode(password),
            AuthorityUtils.createAuthorityList("ROLE_USER")));
        User user = userRepository.findByUsername(username).orElseThrow();
        user.setEmail(email);
        return user;
    }

    public Optional<User> get(Integer id) {
        return userRepository.findById(id);
    }

    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    public void changePassword(String oldPassword, String newPassword, String confirmationPassword) {
        if (!newPassword.equals(confirmationPassword)) {
            throw new IllegalArgumentException();
        }

        String encodedNewPassword = passwordEncoder.encode(newPassword);
        userDetailsManager.changePassword(oldPassword, encodedNewPassword);
    }
}
